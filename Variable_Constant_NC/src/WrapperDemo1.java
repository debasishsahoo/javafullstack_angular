
public class WrapperDemo1 {

	public static void main(String[] args) {
		// Creating wrapper objects
		Integer num = 10;
		Double price = 99.99;
		Character letter = 'Z';
		Boolean flag = true;

		// Autoboxing (primitive to wrapper)
		int x = 50;
		Integer y = x; // Automatically converts int to Integer

		
		// Unboxing (wrapper to primitive)
		Integer a = new Integer(100);
		int b = a; // Automatically converts Integer to int
		
		
		//Utility Methods in Wrapper Classes
		
		// Parse string to primitive
		int parsed = Integer.parseInt("123");
		double value = Double.parseDouble("45.67");

		// Convert to string
		String str1 = Integer.toString(500);
		String str2 = Double.toString(25.5);

		// Find min/max values
		int minInt = Integer.MIN_VALUE;  // -2147483648
		int maxInt = Integer.MAX_VALUE;  // 2147483647

		
		
		
		
		
		
		
		

	}

}
