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
		System.out.println("\n--- Basic Arithmetic ---");

		System.out.print("Enter first number:");
		double num1 = scanner.nextDouble();

		System.out.print("Enter second number:");
		double num2 = scanner.nextDouble();

		System.out.println("Results:");

		System.out.println("Addition: " + num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + (num1 * num2));

		// Division with error handling
		if (num2 != 0) {
			System.out.println("Division: " + num1 + " / " + num2 + " = " + (num1 / num2));
			System.out.println("Modulus: " + num1 + " % " + num2 + " = " + (num1 % num2));

			// Demonstrate type casting
			System.out.println("\nType Casting Examples:");
			System.out.println("Double to Int: " + (int) (num1 / num2));
			System.out.println("Double to Long: " + (long) (num1 / num2));
		} else {
			System.out.println("Division & Modulus: Cannot divide by zero!");
		}
	}

	private static void performPowerCalculation(Scanner scanner) {
		System.out.println("\n--- Power Calculation ---");

		System.out.print("Enter the base number: ");
		double base = scanner.nextDouble();

		System.out.print("Enter the exponent: ");
		int exponent = scanner.nextInt();

		// Calculate power using Math class
		double result = Math.pow(base, exponent);
		System.out.println(base + " raised to the power of " + exponent + " = " + result);

		// Manual calculation for demonstration
		double manualResult = 1;
		for (int i = 0; i < Math.abs(exponent); i++) {
			manualResult *= base;
		}
		if (exponent < 0) {
			manualResult = 1 / manualResult;
		}
		System.out.println("Calculated manually: " + manualResult);
	}

	private static void performSquareRootCalculation(Scanner scanner) {
		System.out.println("\n--- Square Root Calculation ---");

		System.out.print("Enter a number: ");
		double number = scanner.nextDouble();

		if (number >= 0) {
			double sqrtResult = Math.sqrt(number);
			System.out.println("Square root of " + number + " = " + sqrtResult);

		} else {
			System.out.println("Cannot calculate the square root of a negative number in the real domain.");
		}

	}

	private static void performBinaryOperationsCalculation(Scanner scanner) {
		System.out.println("\n--- Binary Operations ---");

		System.out.print("Enter first integer: ");
		int num1 = scanner.nextInt();

		System.out.print("Enter second integer: ");
		int num2 = scanner.nextInt();

		System.out.println("Bitwise AND: " + num1 + " & " + num2 + " = " + (num1 & num2));
		System.out.println("Bitwise OR: " + num1 + " | " + num2 + " = " + (num1 | num2));
		System.out.println("Bitwise XOR: " + num1 + " ^ " + num2 + " = " + (num1 ^ num2));
		System.out.println("Bitwise NOT (first number): ~" + num1 + " = " + (~num1));

		System.out.println("\nBinary representation:");
		System.out.println("First number: " + Integer.toBinaryString(num1));
		System.out.println("Second number: " + Integer.toBinaryString(num2));

		// Shift operations
		System.out.println("\nShift operations on " + num1 + ":");
		
		System.out.println("Left shift by 1: " + num1 + " << 1 = " + (num1 << 1) + " (Binary: " + Integer.toBinaryString(num1 << 1) + ")");
		
		System.out.println("Right shift by 1: " + num1 + " >> 1 = " + (num1 >> 1) + " (Binary: " + Integer.toBinaryString(num1 >> 1) + ")");
		
		System.out.println("Unsigned right shift by 1: " + num1 + " >>> 1 = " + (num1 >>> 1) + " (Binary: " + Integer.toBinaryString(num1 >>> 1) + ")");
	}

	private static void performNumberTypeConversion(Scanner scanner) {
		System.out.println("\n--- Number Type Conversion ---");

		System.out.print("Enter a number (can be decimal): ");
		double inputNumber = scanner.nextDouble();

		// Convert to different types using wrapper classes
		byte byteValue = (byte) inputNumber;
		short shortValue = (short) inputNumber;
		int intValue = (int) inputNumber;
		long longValue = (long) inputNumber;
		float floatValue = (float) inputNumber;

		// Display conversions
		System.out.println("Original (double): " + inputNumber);
		System.out.println("As byte: " + byteValue + (byteValue != inputNumber ? " (possible data loss)" : ""));
		System.out.println("As short: " + shortValue + (shortValue != inputNumber ? " (possible data loss)" : ""));
		System.out.println("As int: " + intValue + (intValue != inputNumber ? " (possible data loss)" : ""));
		System.out.println("As long: " + longValue + (longValue != inputNumber ? " (possible data loss)" : ""));
		System.out.println("As float: " + floatValue + (floatValue != inputNumber ? " (possible precision loss)" : ""));

		// String conversion
		System.out.println("\nString conversions:");
		String numberAsString = Double.toString(inputNumber);
		System.out.println("Number as string: \"" + numberAsString + "\"");

		// Parse back
		try {
			double parsedBack = Double.parseDouble(numberAsString);
			System.out.println("Parsed back to double: " + parsedBack);
		} catch (NumberFormatException e) {
			System.out.println("Error parsing the string back to a number!");
		}

		// Demonstrate auto-boxing and unboxing
		System.out.println("\nAuto-boxing and unboxing:");
		Double doubleObject = inputNumber; // Auto-boxing
		double primitiveAgain = doubleObject; // Unboxing

		System.out.println("Auto-boxed to Double object: " + doubleObject);
		System.out.println("Unboxed back to primitive: " + primitiveAgain);
	}

}
