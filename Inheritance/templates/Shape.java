public class Shape {

	private String shapeName;

	public Shape(String shapeName) {
		// TODO
		// debug("Shape(String)");
	}

	public Shape() {
		// TODO
		// debug("Shape()");
	}

	public String getName() {
		return this.shapeName;
	}

	public static boolean debug = true;

	public void debug(String text) {
		if (debug) {
			System.out.println(this.getClass().getName() + ": " + text);
		}
	}
}
