package typecasting;

public class ImplicitCasting_Widening {

//	byte → short → int → long → float → double
//           ↑
//          char

	public static void main(String[] args) {

		System.out.println("=== IMPLICIT CASTING (WIDENING) EXAMPLES ===\n");
		// 1. NUMERIC WIDENING - Smaller to Larger Data Types
		System.out.println("1. Numeric Widening:");

		// byte -> short -> int -> long -> float -> double
		byte byteValue = 10;
		short shortValue = byteValue; // byte to short (implicit)
		
		int intValue = shortValue; // short to int (implicit)
		
		long longValue = intValue; // int to long (implicit)
		
		float floatValue = longValue; // long to float (implicit)
		
		double doubleValue = floatValue; // float to double (implicit)
		
		

		System.out.println("byte: " + byteValue);
		System.out.println("short: " + shortValue);
		System.out.println("int: " + intValue);
		System.out.println("long: " + longValue);
		System.out.println("float: " + floatValue);
		System.out.println("double: " + doubleValue);
		
		// 2. CHAR TO INT WIDENING
        System.out.println("\n2. Character to Integer:");
        char ch = 'A';
        int asciiValue = ch;  // char to int (implicit)
        System.out.println("char 'A': " + ch);
        System.out.println("ASCII value: " + asciiValue);
		
        // 3. MIXED ARITHMETIC OPERATIONS
        System.out.println("\n3. Mixed Arithmetic Operations:");
        int a = 5;
        double b = 2.5;
        double result = a + b;  // int 'a' is widened to double
        System.out.println("int " + a + " + double " + b + " = " + result);
		
        
     // 4. METHOD PARAMETER WIDENING
        System.out.println("\n4. Method Parameter Widening:");
        int number = 42;
        printDouble(number);  // int is widened to double automatically
        
        
        
        
        
        
       
        // 5. ASSIGNMENT WITH LITERALS
        System.out.println("\n5. Literal Assignment Widening:");
        long bigNumber = 123456789;  // int literal widened to long
        double decimal = 100;        // int literal widened to double
        System.out.println("long: " + bigNumber);
        System.out.println("double: " + decimal);
        
        
        
        
        
        
        
        
        // 6. WIDENING IN EXPRESSIONS
        System.out.println("\n6. Expression Widening:");
        byte b1 = 10;
        byte b2 = 20;
        // Note: byte + byte results in int, so this requires explicit cast
        //int sum = b1 + b2;  // This works (widening to int)
        int sum = b1 + b2;
        System.out.println("byte + byte = int: " + sum);
        
        
        
        System.out.println("\n6. Expression Widening:");
        int b_1 = 10;
        int b_2 = 20;
        // Note: byte + byte results in int, so this requires explicit cast
        //int sum = b1 + b2;  // This works (widening to int)
        int sum1 = b_1 + b_2;
        System.out.println("byte + byte = int: " + sum1);
        
        
        
        
        
        // 7. HIERARCHY DEMONSTRATION
        demonstrateWideningHierarchy();
		

	}
	// Method that accepts double parameter
    public static void printDouble(double value) {
        System.out.println("Received double: " + value);
    }
    
    
    
    
    
    
 // Demonstrate the complete widening hierarchy
    public static void demonstrateWideningHierarchy() {
        System.out.println("\n7. Complete Widening Hierarchy:");
        System.out.println("byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)");
        System.out.println("       \\-> char(2) -> int(4) -> ...");
        
        byte b = 1;
        short s = b;     // byte -> short
        int i = s;       // short -> int
        long l = i;      // int -> long
        float f = l;     // long -> float
        double d = f;    // float -> double
        
        System.out.println("Final double value: " + d);
        
        // Character path
        char c = 65;     // 'A'
        int fromChar = c; // char -> int
        System.out.println("char 'A' as int: " + fromChar);
    }

}
