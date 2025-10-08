package AdvancedConcepts3;

public class Division extends MathOperations {
	@Override
	double calculate(double x, double y) {
		if (y == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return x / y;
	}

	// Cannot override printWelcome() as it's final
//	@Override
//	public final void printWelcome() {
//	};

	// Cannot override add() as it's static
//	@Override
//	public static int add(int a, int b) {
//	};

}
