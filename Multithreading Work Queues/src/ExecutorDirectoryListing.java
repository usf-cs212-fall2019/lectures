import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class demonstrates a slightly better option than
 * {@link MultithreadedDirectoryListing} for making a multithreaded version of
 * {@link SerialDirectoryListing}.
 *
 * Note: With a tweak to our work queues (moving the pending variable there),
 * we can avoid needing the TaskMaster class entirely!
 */
public class ExecutorDirectoryListing {

	/** Logger to use for this class. */
	private static final Logger log = LogManager.getLogger();

	/**
	 * Returns a directory listing for the given path.
	 *
	 * @param path directory to create listing
	 * @return paths found within directory and its subdirectories
	 * @throws InterruptedException
	 */
	public static Set<Path> list(Path path) throws InterruptedException {
		HashSet<Path> paths = new HashSet<>();

		if (Files.exists(path)) {
			paths.add(path);

			if (Files.isDirectory(path)) {
				TaskMaster master = new TaskMaster(paths);
				master.start(path);
				master.join();
				master.executor.shutdown();
			}
		}

		return paths;
	}

	/**
	 * Instead of a static worker class, we will create a task master that can
	 * keep track of pending work.
	 */
	private static class TaskMaster {
		/** The shared set of all paths found thus far. */
		private final Set<Path> paths;

		/** The amount of pending (or unfinished) work. */
		private AtomicInteger pending;

		/** The work queue that will handle all of the tasks. */
		private final ExecutorService executor;

		/**
		 * Initializes a task master given a set of paths.
		 *
		 * @param paths the set of shared paths to populate
		 */
		private TaskMaster(Set<Path> paths) {
			this.paths = paths;
			this.pending = new AtomicInteger();
			this.executor = Executors.newFixedThreadPool(WorkQueue.DEFAULT);
		}

		/**
		 * Creates the first task and gives it to the work queue.
		 *
		 * @param path directory to create listing
		 */
		private void start(Path path) {
			executor.execute(new Task(path));
		}

		/**
		 * The non-static task class that will update the shared paths and
		 * pending members in our task master instance.
		 */
		private class Task implements Runnable {
			/** The path to add or list. */
			private final Path path;

			/**
			 * Initializes this task.
			 *
			 * @param path the path to add or list
			 */
			public Task(Path path) {
				this.path = path;
				incrementPending();
				log.debug("Task for {} created.", path);
			}

			@Override
			public void run() {
				Set<Path> local = new HashSet<>();

				try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
					for (Path current : stream) {
						local.add(current);

						if (Files.isDirectory(current)) {
							executor.execute(new Task(current));
						}
					}

					synchronized (paths) {
						paths.addAll(local);
					}
				}
				catch (IOException ex) {
					throw new UncheckedIOException(ex);
				}

				log.debug("Task for {} finished.", path);
				decrementPending();
			}
		}

		/**
		 * Rather than having threads wait for each other (undoing our multithreading),
		 * we will wait until all pending work is completed.
		 *
		 * @throws InterruptedException
		 */
		private void join() throws InterruptedException {
			log.debug("Waiting for work...");

			while (pending.get() > 0) {
				// we still need to synchronize our wait() and notifyAll()
				synchronized (pending) {
					pending.wait();
				}
				log.debug("Woke up with pending at {}.", pending);
			}

			log.debug("Work finished.");
		}

		/**
		 * Safely increments the shared pending variable.
		 */
		private void incrementPending() {
			pending.incrementAndGet();
		}

		/**
		 * Safely decrements the shared pending variable, and wakes up any threads
		 * waiting for work to be completed.
		 */
		private void decrementPending() {
			if (pending.decrementAndGet() == 0) {
				// we still need to synchronize our wait() and notifyAll()
				synchronized (pending) {
					pending.notifyAll();
				}
			}
		}
	}

	/**
	 * Tests the directory listing for the current directory.
	 *
	 * @param args unused
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Path path = Path.of(".");
		Set<Path> actual = list(path);
		Set<Path> expected = SerialDirectoryListing.list(path);

		System.out.println(actual.equals(expected));
	}
}
