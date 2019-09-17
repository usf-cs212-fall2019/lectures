import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class TextFileStreamer {

	public static void streamTextFile1(/* TODO */) throws IOException {

		// TODO

	}

	public static List<String> listWords1(Path path, Function<String, String> clean)
			throws IOException {
		List<String> words = new ArrayList<String>();
		// TODO
		return words;
	}

	public static void /* TODO */ streamTextFile2(
			Path path,
			Function<String, String> clean,
			Function<String, String[]> tokenize
			/* TODO */
	) throws IOException {

		try (
				BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
				Stream<String> lines = reader.lines();
		) {
			// TODO
		}
	}

	public static List<String> listWords2(Path path, Function<String, String> clean)
			throws IOException {
		return null; // TODO
	}

	public static void main(String[] args) throws IOException {
		// Path sally = Path.of("sally.txt");
		// TODO
	}
}
