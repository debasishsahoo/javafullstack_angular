/**
 * Interactive Hello World demonstrating:
 * - User input using Scanner
 * - Input validation
 * - Formatted output
 */

import java.util.Scanner;

public class InteractiveHelloWorld {
  public static void main(String[] args) {
    // Create scannerObj object for input
    Scanner scannerObj = new Scanner(System.in);

    // Get user information
    System.out.print("Enter your name: ");
    String name = scannerObj.nextLine();

    System.out.print("Enter your age: ");
    int age = scannerObj.nextInt();

    System.out.print("Enter your favorite programming language: ");
    scannerObj.nextLine(); // Consume newline
    String language = scannerObj.nextLine();

    // Display personalized greeting
    System.out.println("\n=== Personal Greeting ===");
    System.out.println("Hello, " + name + "!");
    System.out.println("Age: " + age + " years old");
    System.out.println("Favorite language: " + language);
    System.out.println("Welcome to the Java learning journey!");

    // Close scannerObj
    scannerObj.close();
  }
}
