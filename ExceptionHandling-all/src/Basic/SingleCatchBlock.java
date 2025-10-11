package Basic;

public class SingleCatchBlock {
	public static void main(String[] args) {
		try {
			// Code that might throw an exception
			int result = 10 / 0; // This will cause ArithmeticException
			System.out.println("Result: " + result);
		} catch (ArithmeticException e) {
			// Handle the exception
			System.out.println("Cannot divide by zero: " + e.getMessage());
		} finally {
			// Always executes (optional)
			System.out.println("Cleanup code (Finally block always executes)");
		}

		System.out.println("Program continues after try-catch-finally block...");
	}
}
