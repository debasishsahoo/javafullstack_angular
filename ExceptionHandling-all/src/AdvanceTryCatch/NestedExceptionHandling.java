package AdvanceTryCatch;
//Each try can have its own catch and finally.
//The inner finally runs even if a new exception is thrown.
//The outer catch handles any rethrown or uncaught exceptions.
//The outer finally always executes last.


public class NestedExceptionHandling {

	public static void main(String[] args) {
		try {
			System.out.println("Outer try block"); //-1

			try {
				System.out.println("Inner try block");//-2
				int[] arr = { 1, 2, 3 };
				System.out.println(arr[5]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Inner catch: " + e.getMessage());//3
				throw new RuntimeException("Wrapped exception");//5
			} finally {
				System.out.println("Inner finally");//4
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Outer catch: " + e.getMessage());
		} finally {
			System.out.println("Outer finally");//6
		}

	}

}
