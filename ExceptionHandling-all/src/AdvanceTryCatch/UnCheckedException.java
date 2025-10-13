package AdvanceTryCatch;

public class UnCheckedException {

	public static void main(String[] args) {
		// NullPointerException
		String str = null;
		try {
			int length = str.length(); // NPE
		} catch (NullPointerException e) {
			System.out.println("Null reference: " + e.getMessage());
		}
		// ArrayIndexOutOfBoundsException
		int[] numbers = {1, 2, 3};
        try {
            int value = numbers[5]; // Index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + e.getMessage());
        }
		
		
		
		
		// ArithmeticException
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
        
		// ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj; // Invalid cast
        } catch (ClassCastException e) {
            System.out.println("Cast error: " + e.getMessage());
        }
        
		// NumberFormatException
        try {
			int num = Integer.parseInt("abc123"); // Invalid format
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
	}

}
