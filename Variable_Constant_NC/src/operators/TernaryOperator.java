package operators;

public class TernaryOperator {

	public static void main(String[] args) {
		// syntax: condition ? expression1 : expression2

		int age = 20;
		String status = (age >= 18) ? "Adult" : "Minor"; // "Adult"

		// Equivalent if-else
		String status2;
		if (age >= 18) {
			status2 = "Adult";
		} else {
			status2 = "Minor";
		}

	}

}
