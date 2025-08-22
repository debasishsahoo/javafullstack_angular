package OperatorPrecedence;

public class PrecedenceExample {

	public static void main(String[] args) {
		String[] words = { "hello", "world" };
		// Dot operator has higher precedence than array access
		int length = words[0].length(); // First access words[0], then call length()

		// Equivalent to: (words[0]).length()
		// Not: words[(0.length())] - this would be invalid

		System.out.println("Length of first word: " + length);
	}

}
