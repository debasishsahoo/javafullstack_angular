package operators;

public class RelationalOperators {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		boolean equal = (a == b);           // Equal to: false
		boolean notEqual = (a != b);        // Not equal to: true
		boolean greater = (a > b);          // Greater than: false
		boolean less = (a < b);             // Less than: true
		boolean greaterOrEqual = (a >= b);  // Greater than or equal to: false
		boolean lessOrEqual = (a <= b);     // Less than or equal to: true

		
		System.out.println(equal);
		System.out.println(notEqual);
		System.out.println(greater);
		System.out.println(less);
		System.out.println(greaterOrEqual);
		System.out.println(lessOrEqual);
		
		

	}

}
