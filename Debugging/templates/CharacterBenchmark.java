import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

public class CharacterBenchmark {

	public static void main(String[] args) throws Exception {
		int warmup = 3;
		int runs = 10;

		Path file1 = Path.of("text", "pg1661.txt");
		Path file2 = Path.of("text", "pg2701.txt");

		Instant start;
		Duration elapsed;
		
		double single = 0;
		double multiple = 0;

		/*
		 * Make sure you DISABLE LOGGING before running this benchmark!
		 */

		// TODO

		single /= runs;
		single /= Duration.ofSeconds(1).toMillis();

		System.out.printf("Took %.05f seconds average for sequential comparison.%n", single);

		/* MULTITHREADING */

		// TODO

		multiple /= runs;
		multiple /= Duration.ofSeconds(1).toMillis();
		System.out.printf("Took %.05f seconds average for concurrent comparison.%n", multiple);

		double speedup = single / multiple;
		System.out.printf("Execution time speedup: %.02f times faster%n", speedup);
	}
}
