
import java.util.Scanner;
public class DoWhileExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int number;

        // This loop will always execute at least once
        do {
            System.out.print("Enter a positive number: ");
            number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("That's not a positive number. Try again.");
            }
        } while (number <= 0);

        System.out.println("You entered: " + number);
        scanner.close();

	}

}
