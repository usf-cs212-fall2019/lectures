/**
 * Demonstrates one difference (namely the use of the {@code this} keyword)
 * between lambda expressions and traditional classes, static nested classes,
 * inner classes, and anonymous classes.
 *
 * @see Foo
 * @see Bar
 *
 * @see FunctionalInterface
 */
public class LambdaDemo {

	/**
	 * An example static nested class.
	 */
	public static class Baz implements Foo {
		@Override
		public void foo() {
			System.out.println(this.getClass().getTypeName());
		}
	}

	/**
	 * An example inner (non-static) class.
	 */
	public class Qux implements Foo {
		@Override
		public void foo() {
			System.out.println(this.getClass().getTypeName());
		}
	}

	/**
	 * Instantiating a normal class.
	 */
	public void normalClass() {
		Foo foobar = new Bar();
		foobar.foo();
	}

	/**
	 * Instantiating a static nested class.
	 */
	public void nestedClass() {
		Foo foobar = new Baz();
		foobar.foo();
	}

	/**
	 * Instantiating an inner class.
	 */
	public void innerClass() {
		Foo foobar = new Qux();
		foobar.foo();
	}

	/**
	 * Instantiating an anonymous inner class.
	 */
	public void anonymousClass() {
		Foo foobar = new Foo() {
			@Override
			public void foo() {
				System.out.println(this.getClass().getTypeName());
			}
		};
		foobar.foo();
	}

	/**
	 * Using a lambda expression to define the method.
	 */
	public void lambdaExpression() {
		Foo foobar = () -> {
			System.out.println(this.getClass().getTypeName());
		};
		foobar.foo();
	}

	/**
	 * Demonstrating the classes and methods in this demo.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		LambdaDemo demo = new LambdaDemo();
		demo.normalClass();
		demo.nestedClass();
		demo.innerClass();
		demo.anonymousClass();
		demo.lambdaExpression();

		// another anonymous inner class
		Foo foobar = new Foo() {
			@Override
			public void foo() {
				System.out.println(this.getClass().getTypeName());
			}
		};
		foobar.foo();

		/*
		 * Since we are in a static method, there is no "this" context for the
		 * lambda expression below to reference. Remember, lambda expressions are
		 * NOT quite objects (and do not create a new scope)!
		 */

		Foo foobaz = () -> {
			// System.out.println(this.getClass().getTypeName());
			System.out.println("Foobaz");
		};
		foobaz.foo();

		System.out.println(foobaz.getClass().getTypeName());
	}
}
