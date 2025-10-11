package PrivateInnerClass;

public class OuterClass {
	private String outerField;

	// Private inner class - completely encapsulated
	private class InnerClass {
		public void accessOuter() {
			// Can access private members of outer class
			System.out.println(outerField);
		}
	}

	public void useInner() {
		InnerClass inner = new InnerClass();
		inner.accessOuter();
	}
}
