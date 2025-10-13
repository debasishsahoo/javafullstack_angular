package AdvanceTryCatch;

public class FinallyBehaviorExample {
	// 1. Finally always executes, even with return statements
	public static int testFinally() {
		try {
			System.out.println("Try block");
			return 1;
		} catch (Exception e) {
			System.out.println("Catch block");
			return 2;
		} finally {
			System.out.println("Finally block");
			// Executes before returning
			// Uncomment below line to override return from try/catch
			// return 3;

		}
	}

	// 2.Finally executes even when an exception is thrown
	public static void finallyWithException() {
		try {
			throw new RuntimeException("Error!");
		} finally {
			System.out.println("Cleanup happens even with exception");
			// Executes before exception propagates
		}
	}
	
	//Finally does NOT execute only in special cases
	 public static void finallyNotExecuted() {
		 try {
	            System.out.println("About to exit program...");
	            System.exit(0); // JVM exits — finally won’t run
	        } finally {
	            System.out.println("This won't print");
	        }
	 }
	
	
	

	public static void main(String[] args) {
		System.out.println("---- Example 1: testFinally() ----");
		int result = testFinally();
		System.out.println("Returned value: " + result);
		
		
		System.out.println("\n---- Example 2: finallyWithException() ----");
        try {
            finallyWithException();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("\n---- Example 3: finallyNotExecuted() ----");
        finallyNotExecuted(); // This will terminate the program before finally runs

	}

}
