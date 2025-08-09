
public class WrapperDemo2 {

	public static void main(String[] args) {
		
		// 1. Primitive to Wrapper (Boxing)
        Integer intObj = Integer.valueOf(100);       // Explicit boxing
        Double doubleObj = 3.14;                     // Autoboxing (Java 5+)
        Character charObj = 'A';
        Boolean boolObj = true;

        // 2. Wrapper to Primitive (Unboxing)
        int intPrim = intObj;                        // Auto-unboxing
        double doublePrim = doubleObj.doubleValue(); // Explicit unboxing
        char charPrim = charObj;
        boolean boolPrim = boolObj;

        // 3. String to Wrapper/Primitive
        String numberStr = "123";
        Integer fromStr = Integer.parseInt(numberStr);   // String → int → Integer
        Double pi = Double.valueOf("3.14159");           // String → Double
        
     // 4. Wrapper to String
        String intString = intObj.toString();
        String doubleString = Double.toString(3.14);

        // 5. Constants and Utilities
        System.out.println("Max Integer: " + Integer.MAX_VALUE);
        System.out.println("Min Double: " + Double.MIN_VALUE);
        System.out.println("Binary: " + Integer.toBinaryString(42));

        // 6. Null Handling
        Integer nullable = null;
        // int risky = nullable;  // NullPointerException at runtime!
        int safe = nullable != null ? nullable : 0;

        // 7. Collections Usage
        java.util.ArrayList<Double> prices = new java.util.ArrayList<>();
        prices.add(9.99);      // Autoboxing
        prices.add(19.95);
        double total = prices.get(0) + prices.get(1);  // Unboxing
        
        
        // Print results
        System.out.println("\n--- Results ---");
        System.out.println("Unboxed int: " + intPrim);
        System.out.println("From String: " + fromStr);
        System.out.println("Total price: $" + total);
        System.out.println("Safe null: " + safe);

	}

}
