package operators;

public class LogicalOperators {

	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;

		boolean andResult = x && y;  // Logical AND: false
		boolean orResult = x || y;   // Logical OR: true
		boolean notResult = !x;      // Logical NOT: false

		// Short-circuit evaluation
		boolean result = (5 > 3) && (10 > 5);  // true && true = true
		boolean result2 = (5 < 3) && (methodWithSideEffects());  // false && anything = false
		                                        // methodWithSideEffects() is never called


	}

	private static boolean methodWithSideEffects() {
		return false;
	}

}
