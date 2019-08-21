import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamDemo {

	private static final String FORMAT = "%s (%d bytes)%n";

	private static void traverseDirectory(Path directory) throws IOException {
		// TODO
	}

	public static void printListing(Path start) throws IOException {
		// TODO
	}

	public static void main(String[] args) throws IOException {
		Path path = Path.of(".").normalize();
		printListing(path);
	}

}
