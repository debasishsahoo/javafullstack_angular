package activity_1;

import java.util.Scanner; //For User Input

public class EnhancedCalculator {
	private static final String WELCOME_MESSAGE = "Welcome to the Java Calculator";
	private static final String MENU = "\nPlease select an operation:" + "\n1.  Basic Arithmetic (+, -, *, /, %)"
			+ "\n2. Power Calculation" + "\n3. Square Root" + "\n4. Binary Operations" + "\n5. Number Type Conversion"
			+ "\n6. Exit";
	private static final double PI = 3.14159265359;

	public static void main(String[] args) {
		// Variables declaration
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean running = true;

		System.out.println(WELCOME_MESSAGE);
		System.out.println("PI value (constant): " + PI);

		// Main calculator loop
		while (running) {
			// Display menu
			System.out.println(MENU);

			// Get user's choice
			System.out.print("\nEnter your choice (1-6): ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				performBasicArithmetic(scanner);
				break;
				
			case 2:
				performPowerCalculation(scanner);
				break;
			case 3:
				performSquareRootCalculation(scanner);
				break;
			case 4:
				performBinaryOperationsCalculation(scanner);
				break;
			case 5:
				performNumberTypeConversion(scanner);
				break;
			case 6:
                running = false;
                System.out.println("Thank you for using the Enhanced Calculator!");
                break;
			default:
                System.out.println("Invalid choice! Please try again.");
			}
			

		}

		scanner.close();
	}

	private static void performBasicArithmetic(Scanner scanner) {
	}

	private static void performPowerCalculation(Scanner scanner) {
	}

	private static void performSquareRootCalculation(Scanner scanner) {
	}

	private static void performBinaryOperationsCalculation(Scanner scanner) {
	}

	private static void performNumberTypeConversion(Scanner scanner) {
	}

}
