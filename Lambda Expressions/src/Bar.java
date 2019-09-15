/**
 * A simple class that implements a functional interface.
 *
 * @see Foo
 * @see LambdaDemo
 */
public class Bar implements Foo {

	@Override
	public void foo() {
		// Using getTypeName() because it provides output even with anonymous
		// classes and lambda expressions
		System.out.println(this.getClass().getTypeName());
	}

}
