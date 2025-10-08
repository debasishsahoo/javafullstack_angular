import java.util.Scanner;

public class InputHelper {
	private static Scanner scanner = new Scanner(System.in);

	public static int getIntInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				int value = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				return value;
			} catch (Exception e) {
				System.out.println(" Invalid input! Please enter a number.");
				scanner.nextLine(); // Clear buffer
			}
		}
	}

	public static double getDoubleInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				double value = scanner.nextDouble();
				scanner.nextLine(); // Consume newline
				return value;
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a valid number.");
				scanner.nextLine(); // Clear buffer
			}
		}
	}

	public static String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	public static void close() {
		scanner.close();
	}
}
