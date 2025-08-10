
public class IfElseExample {

	public static void main(String[] args) {
		int score = 85;

		// Simple if-else to determine pass/fail
		if (score >= 60) {
			System.out.println("Result: Pass");
		} else {
			System.out.println("Result: Fail");
		}

		// Extended if-else to determine grade
		if (score >= 90) {
			System.out.println("Grade: A");
		} else if (score >= 80) {
			System.out.println("Grade: B");
		} else if (score >= 70) {
			System.out.println("Grade: C");
		} else if (score >= 60) {
			System.out.println("Grade: D");
		} else {
			System.out.println("Grade: F");
		}

	}

}
