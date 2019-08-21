@SuppressWarnings({"javadoc", "unused"})
public class ExceptionDemo {

	private static int calcPercentage(int total, int possible) {
		return 100 * total / possible;
	}

	private static void printResult(int total, int possible, int percentage) {
		System.out.printf("%d/%d = %d%% %n", total, possible, percentage);
	}

	public static void uncaughtDemo() {
		int earned = 0;
		int possible = 0;
		int percentage = 0;

		// TODO
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	@SuppressWarnings("resource")
	public static void validationDemo() {
		int earned = 0;
		int possible = 0;
		int percentage = 0;

		// TODO
		throw new UnsupportedOperationException("Not yet implemented.");

//		System.out.print("Enter total points earned: ");
//		System.err.println("Please enter integer values.");
//		System.out.print("Enter total points possible: ");
//		System.err.println("Please enter integer values.");
//		System.err.println("Please enter non-negative values.");
	}

	public static void catchAllDemo() {
		int earned = 0;
		int possible = 0;
		int percentage = 0;

		// TODO
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public static void resourcefulDemo() {
		int earned = 0;
		int possible = 0;
		int percentage = 0;

		// TODO
		throw new UnsupportedOperationException("Not yet implemented.");

//		System.out.print("Enter total points earned: ");
//		System.out.print("Enter total points possible: ");
//		throw new IllegalArgumentException("Values must be non-negative.");
//		System.err.println("Please enter integer values.");
//		System.err.println("Please enter non-negative values.");
//		System.err.println(e.toString());
	}

	public static void main(String[] args) {
		// Earned: 2, Possible: 4, Percentage: 30%
		// Earned: a, Error
		// Earned: 2, Possible: a, Error
		// Earned: 2, Possible: 0, Error
		// Earned: 2, Possible: -1, Error?

//		uncaughtDemo();
//		validationDemo();
//		catchAllDemo();
//		resourcefulDemo();
	}
}
