
public class ForLoopExample {

	public static void main(String[] args) {
		// Basic for loop to print numbers 1 to 5
		System.out.println("Counting from 1 to 5:");
		for (int i = 1; i <= 5; i++) {
			System.out.println("Count: " + i);
		}
		
		// For loop to calculate sum of numbers 1 to 10
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i; // Add current value to sum
		}
		
		System.out.println("Sum of numbers 1 to 10: " + sum);

	
		
		// Nested for loop to create a simple multiplication table
		System.out.println("\nMultiplication Table (1-3):");
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println(); // New line after each row
		}

	}

}
