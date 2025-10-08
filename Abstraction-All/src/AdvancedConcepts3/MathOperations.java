package AdvancedConcepts3;

public abstract class MathOperations {
	// Static method in abstract class
	public static int add(int a, int b) {
		return a + b;
	}

	// Final method (cannot be overridden)
	public final void printWelcome() {
		System.out.println("Welcome to Math Operations!");
	}

	// Abstract method
	abstract double calculate(double x, double y);

	// Concrete method
	public void displayResult(double result) {
		System.out.println("Result: " + result);
	}
}
