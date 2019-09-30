import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Approximates the runtime differences between the sequential and concurrent
 * approaches. Note: Benchmarking is difficult in Java. For more sophisticated
 * benchmarking, look into benchmarking extensions or third-party libraries.
 *
 * @see CharacterFinder
 * @see CharacterCompare
 * @see CharacterBenchmark
 */
public class CharacterBenchmark {

	/**
	 * Demonstrates this class
	 *
	 * @param args unused
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int warmup = 3;
		int runs = 10;

		Path file1 = Path.of("text", "pg1661.txt");
		Path file2 = Path.of("text", "pg2701.txt");

		Instant start;
		Duration elapsed;

		double single = 0;
		double multiple = 0;

		int result = 0;

		/*
		 * Make sure you DISABLE LOGGING before running this benchmark!
		 */
		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.OFF);

		for (int i = 0; i < warmup; i++) {
			result = Math.max(result, CharacterCompare.compareSequentially(file1, file2, 'c'));
		}

		for (int i = 0; i < runs; i++) {
			start = Instant.now();
			result = Math.max(result, CharacterCompare.compareSequentially(file1, file2, 'c'));
			elapsed = Duration.between(start, Instant.now());
			single += elapsed.toMillis();
		}

		single /= runs;
		single /= Duration.ofSeconds(1).toMillis();

		System.out.printf("Took %.05f seconds average for sequential comparison.%n", single);

		/* MULTITHREADING */

		for (int i = 0; i < warmup; i++) {
			result = Math.max(result, CharacterCompare.compareConcurrently(file1, file2, 'c'));
		}

		for (int i = 0; i < runs; i++) {
			start = Instant.now();
			result = Math.max(result, CharacterCompare.compareConcurrently(file1, file2, 'c'));
			elapsed = Duration.between(start, Instant.now());
			multiple += elapsed.toMillis();
		}

		multiple /= runs;
		multiple /= Duration.ofSeconds(1).toMillis();
		System.out.printf("Took %.05f seconds average for concurrent comparison.%n", multiple);

		double speedup = single / multiple;
		System.out.printf("Execution time speedup: %.02f times faster%n", speedup);
	}
}
