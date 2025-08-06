public class FormattingMethod {

  public static void main(String[] args) {
    // Call a method to get the greeting
    String message = createGreeting("World");

    // Display the greeting
    System.out.println(message);

    // Use string formatting for another greeting
    String formattedMessage = String.format(
      "Hello, %s! Today is a great day to learn Java.",
      "Developer"
    );
    System.out.println(formattedMessage);
  }

  // Method that creates a greeting message
  public static String createGreeting(String name) {
    return "Hello, " + name + "!";
  }
}
