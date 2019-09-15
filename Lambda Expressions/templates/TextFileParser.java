import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFileParser {

	public static List<String> listWords(/* TODO */)
			throws IOException {
		List<String> words = new ArrayList<>();

		// TODO

		return words;
	}

	public static void parseWords1(/* TODO */)
			throws IOException {
		// TODO
	}

	public static void parseWords2(/* TODO */)
			throws IOException {
		// TODO
	}

	public static List<String> listWords2(/* TODO */)
			throws IOException {
		return null; // TODO
	}

	public static String removePunctuation(String text) {
		return text.replaceAll("(?U)\\p{Punct}+", "");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		Path path = Path.of("sally.txt");

		// TODO
	}
}
