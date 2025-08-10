package typecasting;

public class ExplicitCasting_Narrowing {

	public static void main(String[] args) {
		System.out.println("=== EXPLICIT CASTING (NARROWING) EXAMPLES ===\n");

		// 1. BASIC NUMERIC NARROWING
		System.out.println("1. Basic Numeric Narrowing:");

		double doubleValue = 123.456;
		float floatValue = (float) doubleValue; // double to float
		long longValue = (long) floatValue; // float to long
		int intValue = (int) longValue; // long to int
		short shortValue = (short) intValue; // int to short
		byte byteValue = (byte) shortValue; // short to byte

		System.out.println("Original double: " + doubleValue);
		System.out.println("Cast to float: " + floatValue);
		System.out.println("Cast to long: " + longValue);
		System.out.println("Cast to int: " + intValue);
		System.out.println("Cast to short: " + shortValue);
		System.out.println("Cast to byte: " + byteValue);
		
		

		// 2. DATA LOSS DEMONSTRATION
		System.out.println("\n2. Data Loss Examples:");

		// Decimal truncation
		double decimal = 99.99;
		int truncated = (int) decimal;
		System.out.println("double 99.99 -> int: " + truncated + " (decimal lost)");

		
		// Overflow example
		int largeInt = 300;
		byte overflowed = (byte) largeInt;
		System.out.println("int 300 -> byte: " + overflowed + " (overflow occurred)");

		// Precision loss
		long preciseLong = 1234567890123456789L;
		float lessPrec = (float) preciseLong;
		System.out.println("long: " + preciseLong);
		System.out.println("float: " + lessPrec + " (precision lost)");

		
		
		
		
		
		
		
		// 3. CHARACTER CONVERSIONS
		System.out.println("\n3. Character Conversions:");

		int ascii = 65;
		char character = (char) ascii; // int to char
		System.out.println("int 65 -> char: '" + character + "'");

		
		int unicodeValue = 8364; // Euro symbol
		char euroSymbol = (char) unicodeValue;
		System.out.println("int 8364 -> char: '" + euroSymbol + "'");

		
		
		// 4. OBJECT CASTING (DOWNCASTING)
		System.out.println("\n4. Object Downcasting:");
		demonstrateObjectCasting();

		// 5. DANGEROUS CASTING SCENARIOS
		System.out.println("\n5. Dangerous Casting Scenarios:");
		demonstrateDangerousCasting();

		// 6. SAFE CASTING PRACTICES
		System.out.println("\n6. Safe Casting Practices:");
		demonstrateSafeCasting();

		// 7. CASTING IN ARITHMETIC
		System.out.println("\n7. Casting in Arithmetic:");
		demonstrateArithmeticCasting();
	}

	// Object casting demonstration
	public static void demonstrateObjectCasting() {
		// Upcasting (implicit)
		String str = "Hello";
		Object obj = str; // String -> Object (implicit)

		// Downcasting (explicit)
		String backToString = (String) obj; // Object -> String (explicit)
		System.out.println("Downcast result: " + backToString);

		// Array example
		Object[] objects = { "Hello", "World" };
		String firstString = (String) objects[0]; // Object -> String
		System.out.println("Array downcast: " + firstString);
	}

	// Demonstrate dangerous casting that can cause issues
	public static void demonstrateDangerousCasting() {
		// Extreme overflow
		long hugeLong = Long.MAX_VALUE;
		int overflowInt = (int) hugeLong;
		System.out.println("Long.MAX_VALUE cast to int: " + overflowInt);

		// Negative number casting
		int negativeInt = -1;
		char charFromNeg = (char) negativeInt;
		int backToInt = (int) charFromNeg;
		System.out.println("int -1 -> char -> int: " + backToInt);

		// Large double to integer
		double largeDouble = 1.7976931348623157E308; // Near Double.MAX_VALUE
		long longFromDouble = (long) largeDouble;
		System.out.println("Large double to long: " + longFromDouble);
	}

	// Safe casting practices
	public static void demonstrateSafeCasting() {
		// Check range before casting
		long longValue = 100L;
		if (longValue >= Integer.MIN_VALUE && longValue <= Integer.MAX_VALUE) {
			int safeInt = (int) longValue;
			System.out.println("Safe cast: " + safeInt);
		} else {
			System.out.println("Cast would cause overflow!");
		}

		// Using wrapper methods for safer conversion
		double doubleVal = 42.7;
		int roundedInt = (int) Math.round(doubleVal); // Round instead of truncate
		System.out.println("Rounded cast: " + doubleVal + " -> " + roundedInt);

		// instanceof check for object casting
		Object obj = "Test String";
		if (obj instanceof String) {
			String str = (String) obj;
			System.out.println("Safe object cast: " + str);
		}
	}

	// Casting in arithmetic operations
	public static void demonstrateArithmeticCasting() {
		// Division with casting
		int a = 7;
		int b = 3;
		double preciseResult = (double) a / b; // Cast to avoid integer division
		System.out.println("7/3 with casting: " + preciseResult);
		System.out.println("7/3 without casting: " + (a / b));

		// Mixed operations
		double x = 10.5;
		int y = 3;
		int result = (int) (x * y); // Explicit cast of entire expression
		System.out.println("(int)(10.5 * 3): " + result);
	}
}
