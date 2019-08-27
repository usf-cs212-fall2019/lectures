import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {

		TreeSet<StringBuilder> set = new TreeSet<>();

		set.add(new StringBuilder("banana"));
		set.add(new StringBuilder("cherry"));
		set.add(new StringBuilder("apple"));

		System.out.println(set);

		// TODO
	}

}
