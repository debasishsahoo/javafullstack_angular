
public class WhileLoopExample {

	public static void main(String[] args) {
		 // Basic while loop to print numbers 1 to 5
        System.out.println("Counting with while loop:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;  // Increment counter
        }

        // While loop with complex condition
        int num = 1;
        int factorial = 1;

        while (factorial < 1000) {
            num++;
            factorial *= num;  // Multiply factorial by next number
            System.out.println(num + "! = " + factorial);
        }
        System.out.println("First factorial greater than 1000 is: " + num + "! = " + factorial);
	}

}
