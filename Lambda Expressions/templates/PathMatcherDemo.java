import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class PathMatcherDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Path path1 = Paths.get("hello.txt");
		Path path2 = Paths.get("txt.hello");

		PathMatcher m1 = null; // TODO

		// TODO

		PathMatcher m2 = null; // TODO

//		System.out.println(path1 + ": " + m2.matches(path1));
//		System.out.println(path2 + ": " + m2.matches(path2));
//		System.out.println();

		PathMatcher m3 = null; // TODO

//		System.out.println(path1 + ": " + m3.matches(path1));
//		System.out.println(path2 + ": " + m3.matches(path2));
//		System.out.println();

		Predicate<Path> m4 = null; // TODO

		// TODO
	}

}
