package activity_1;

import java.util.Scanner; //For User Input

public class Calculator {
	// Constants
	private static final String WELCOME_MESSAGE = "Welcome to the Java Calculator";
	private static final String MENU = "\nPlease select an operation:" + "\n1. Addition" + "\n2. Subtraction"
			+ "\n3. Multiplication" + "\n4. Division" + "\n5. Modulus (Remainder)" + "\n6. Exit";

	public static void main(String[] args) {
		// Variables declaration with different data types
		Scanner scanner = new Scanner(System.in);
		int choice;
		double num1, num2, result;
		boolean running = true;
		char continueChar;
		System.out.println(WELCOME_MESSAGE);

		// Main calculator loop
		while (running) {

			// Display menu
			System.out.println(MENU);

			// Get user's choice
			System.out.print("\nEnter your choice (1-6): ");
			choice = scanner.nextInt();

			// Exit condition
			if (choice == 6) {
				running = false;
				System.out.println("Thank you for using the calculator!");
				continue;
			}

			// Input validation
			if (choice < 1 || choice > 6) {
				System.out.println("Invalid choice! Please try again.");
				continue;
			}

			// Get operands
			System.out.print("Enter first number: ");
			num1 = scanner.nextDouble();

			System.out.print("Enter second number: ");
			num2 = scanner.nextDouble();

			// Process the operation using switch statement
			switch (choice) {
			case 1: // Addition
				result = num1 + num2;
				System.out.println(num1 + " + " + num2 + " = " + result);
				break;

			case 2: // Subtraction
				result = num1 - num2;
				System.out.println(num1 + " - " + num2 + " = " + result);
				break;

			case 3: // Multiplication
				result = num1 * num2;
				System.out.println(num1 + " * " + num2 + " = " + result);
				break;

			case 4: // Division
				if (num2 != 0) {
					result = num1 / num2;
					System.out.println(num1 + " / " + num2 + " = " + result);

					// Demonstrate type casting
					int intResult = (int) result;
					System.out.println("Integer result (after casting): " + intResult);
				} else {
					System.out.println("Error: Division by zero is not allowed!");
				}
				break;

			case 5: // Modulus
				if (num2 != 0) {
					result = num1 % num2;
					System.out.println(num1 + " % " + num2 + " = " + result);
				} else {
					System.out.println("Error: Modulus by zero is not allowed!");
				}
				break;
			default:
                System.out.println("Invalid choice! Please try again.");
			}
			// Ask if user wants to perform another calculation
			System.out.print("\nDo you want to perform another calculation? (Y/N): ");
			continueChar = scanner.next().charAt(0);
			running = (continueChar == 'Y' || continueChar == 'y');

		}

		scanner.close();
	}

}
