package AdvanceedException;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionChaining {

	// Top-level method — catches IOException and wraps it in a CustomException
	public void method1() throws CustomException {
		try {
			method2();
		} catch (IOException e) {
			// Wrap the IOException in a custom exception
			throw new CustomException("Error in method1", e);
		}
	}

	// Second method — catches SQLException and wraps it in an IOException
	public void method2() throws IOException {
		try {
			method3();
		} catch (SQLException e) {
			// Wrap SQLException in IOException
			throw new IOException("Database error wrapped", e);
		}
	}

	// Third method — throws original SQLException
	public void method3() throws SQLException {
		throw new SQLException("Original database error");
	}

	// Helper method to get the deepest root cause of an exception chain
	public static Throwable getRootCause(Throwable t) {
		Throwable cause = t;
		while (cause.getCause() != null) {
			cause = cause.getCause();
		}
		return cause;
	}

	// Helper method to print the entire chain of exceptions
	public static void printExceptionChain(Throwable t) {
		System.out.println("\nException Chain:");
		int level = 0;
		Throwable current = t;
		while (current != null) {
			System.out.println("  ".repeat(level) + current.getClass().getName() + ": " + current.getMessage());
			current = current.getCause();
			level++;
		}
	}

	public static void main(String[] args) {
		ExceptionChaining ec = new ExceptionChaining();
		try {
			ec.method1();
		} catch (CustomException e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println("Cause: " + e.getCause());
			System.out.println("Root cause: " + getRootCause(e));

			// Print full chain
			printExceptionChain(e);
		}
	}

}

//Custom checked exception for demonstration
class CustomException extends Exception {
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
