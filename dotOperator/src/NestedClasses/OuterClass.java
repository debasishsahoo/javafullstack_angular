package NestedClasses;

public class OuterClass {
	private String outerField = "Outer Field";

	// Static nested class
	public static class StaticNestedClass {
		public void display() {
			System.out.println("Static nested class method");
		}
	}

	// Non-static nested class (Inner class)
	public class InnerClass {
		public void display() {
			System.out.println("Inner class accessing: " + outerField);
		}
	}

}
