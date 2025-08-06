/**
 * Formatted Hello World demonstrating:
 * - Printf formatting
 * - Date and time
 * - Mathematical operations
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class FormattedHelloWorld {

  public static void main(String[] args) {
    // Get current date and time
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
      "yyyy-MM-dd HH:mm:ss"
    );

    // Program information
    String programName = "Hello World Java Application";
    double version = 1.0;
    int buildNumber = 100;

      // Display formatted information
        System.out.printf("=== %s ===\n", programName);
        System.out.printf("Version: %.1f (Build %d)\n", version, buildNumber);
        System.out.printf("Executed on: %s\n", now.format(formatter));
        System.out.printf("Java Runtime: %s\n", System.getProperty("java.version"));
        

        // Mathematical demonstration
        int a = 10, b = 20;
        System.out.printf("\nMath Demo: %d + %d = %d\n", a, b, (a + b));
        System.out.printf("Square root of 64: %.2f\n", Math.sqrt(64));
        
        // Final message
        System.out.println("\nHello, World! Ready to explore Java!");


  }
}
