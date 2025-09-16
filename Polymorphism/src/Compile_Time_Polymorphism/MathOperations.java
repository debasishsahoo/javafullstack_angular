package Compile_Time_Polymorphism;




//Method overloading is a feature in Java that allows a class 
//to have multiple methods with the same name but different parameter lists. 
//compiler determines which method to call based on the method signature at compile time.
//Method Overloading 
public class MathOperations {

	// Different parameter types
	public int calculate(int a, int b) {
		return a + b;
	}

	public double calculate(double a, double b) {
		return a + b;
	}

	
	// Different number of parameters
	public int calculate(int a, int b, int c) {
		return a + b + c;
	}

	
	// Different order of parameters
	public String calculate(String str, int num) {
		return str + num;
	}

	public String calculate(int num, String str) {
		return num + str;
	}

	// Variable arguments (varargs)
	public int calculate(int... numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}

	public static void main(String... args) {
		MathOperations mathOps = new MathOperations();
		
		// Different parameter types
        int sumInts = mathOps.calculate(5, 10);
        double sumDoubles = mathOps.calculate(5.5, 10.5);
        
        // Different number of parameters
        int sumThreeInts = mathOps.calculate(1, 2, 3);

        
        // Different order of parameters
        String result1 = mathOps.calculate("Number: ", 100);
        String result2 = mathOps.calculate(200, " is the value");
        
        // Variable arguments (varargs)
        int varArgsSum = mathOps.calculate(1, 2, 3, 4, 5);
        
        // Output results
        System.out.println("Sum of two integers: " + sumInts);
        System.out.println("Sum of two doubles: " + sumDoubles);
        System.out.println("Sum of three integers: " + sumThreeInts);
        System.out.println("String + int: " + result1);
        System.out.println("Int + String: " + result2);
        System.out.println("Sum of varargs integers: " + varArgsSum);
        
	}

}


//Rules
//Multiple methods with the same name in the same class
//Different parameter lists (number, type, or order of parameters)
//Resolved at compile time (static binding)
//Also known as static polymorphism
//Note: Return type is NOT part of the method signature for overloading purposes














