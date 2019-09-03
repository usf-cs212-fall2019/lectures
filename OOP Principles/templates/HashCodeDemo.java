import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings({"javadoc", "deprecation"})
public class HashCodeDemo {

	public static void printHash(String label, Object object) {
		Object[] args = { label, System.identityHashCode(object), object };
		System.out.format("%-9s : x%08X : %s %n", args);
	}

	public static void printHash(String label, Object[] object) {
		Object[] args = { label, System.identityHashCode(object), Arrays.toString(object) };
		System.out.format("%-9s : x%08X : %s %n", args);
	}

	public static void testInteger(Integer value) {
		printHash("INNER BEG", value);
		// TODO
		printHash("INNER END", value);
	}

	public static void testString(String value) {
		printHash("INNER BEG", value);
		// TODO
		printHash("INNER END", value);
	}

	public static void testBuilder(StringBuilder value) {
		printHash("INNER BEG", value);
		// TODO
		printHash("INNER END", value);
	}

	public static void testArray(String[] value) {
		printHash("INNER BEG", value);
		// TODO
		printHash("INNER END", value);
	}

	public static void testList(ArrayList<String> value) {
		printHash("INNER BEG", value);
		// TODO
		printHash("INNER BEG", value);
	}

	public static void main(String[] args) {

		// TODO
		new Integer(0);

//		printHash("OUTER BEG", a);
//		testInteger(a);
//		printHash("OUTER END", a);
//		System.out.println();


		// TODO

//		printHash("VALUE OF", b);
//		printHash("CALL NEW", new Integer(1));
//		System.out.println();

		// TODO

//		printHash("OUTER BEG", c);
//		testString(c);
//		printHash("OUTER END", c);
//		System.out.println();

		// TODO

//		printHash("OUTER BEG", d);
//		testBuilder(d);
//		printHash("OUTER END", d);
//		System.out.println();

		// TODO

//		printHash("OUTER BEG", e);
//		testArray(e);
//		printHash("OUTER END", e);
//		System.out.println();


		// TODO

//		printHash("OUTER BEG", f);
//		testList(f);
//		printHash("OUTER END", f);
	}

}
