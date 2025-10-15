package AdvanceedException;

public class ExceptionFormatter {

	public static String formatException(Throwable t) {
		StringBuilder sb = new StringBuilder();

		// Exception message
		sb.append(t.getClass().getName()).append(": ").append(t.getMessage()).append("\n");

		// Stack trace
		for (StackTraceElement element : t.getStackTrace()) {
			sb.append("\tat ").append(element.toString()).append("\n");
		}
		// Caused by (recursive)
		Throwable cause = t.getCause();
		if (cause != null) {
			sb.append("Caused by: ").append(formatException(cause));
		}

		// Suppressed exceptions
		for (Throwable suppressed : t.getSuppressed()) {
			sb.append("Suppressed: ").append(formatException(suppressed));
		}

		return sb.toString();

	}

	public static String formatCompact(Throwable t) {
		return String.format("%s: %s _at_ %s", t.getClass().getSimpleName(), t.getMessage(),
				t.getStackTrace()[0].toString());
	}

	public static void main(String[] args) {
		try {
			simulateException();
		} catch (Exception e) {
			System.out.println("=== Full Exception Format ===");
			System.out.println(formatException(e));

			System.out.println("\n=== Compact Exception Format ===");
			System.out.println(formatCompact(e));
		}
	}

	// Helper method to simulate nested exceptions
	public static void simulateException() throws Exception {
		try {
			methodA();
		} catch (RuntimeException e) {
			Exception custom = new Exception("High-level exception occurred", e);
			// Add a suppressed exception
			custom.addSuppressed(new IllegalStateException("Suppressed error example"));
			throw custom;
		}

	}

	public static void methodA() {
		throw new RuntimeException("Something went wrong inside methodA");
	}

}
