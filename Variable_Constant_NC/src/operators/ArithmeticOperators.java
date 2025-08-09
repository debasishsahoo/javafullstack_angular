package operators;

public class ArithmeticOperators {

	public static void main(String[] args) {
		int a = 10;
		int b = 3;

		int sum = a + b;        // Addition: 13
		int difference = a - b; // Subtraction: 7
		int product = a * b;    // Multiplication: 30
		int quotient = a / b;   // Division: 3 (integer division truncates)
		int remainder = a % b;  // Modulus (remainder): 1

		// Increment and decrement
		int x = 5;                 
		                

		System.out.println(sum);
		System.out.println(difference);
		System.out.println(product);
		System.out.println(quotient);
		System.out.println(remainder);
		
		
		System.out.println(x++); // Post-increment: x becomes 6
		System.out.println(++x); // Pre-increment: x becomes 7
		System.out.println(x--); // Post-decrement: x becomes 6
		System.out.println(--x); // Pre-decrement: x becomes 5
		System.out.println(remainder);
		
		
		
		
		
		

	}

}
