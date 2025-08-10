
public class MethodExamples {

	public static void main(String[] args) {

//		[access_modifier] [static] [return_type] method_name([parameter_list]) {
//		    // Method body
//		    // Statements
//		    [return value;]
//		}

//		Components:
//
//			Access Modifier: Controls visibility (public, private, protected, default)
//			Static: Optional keyword for class-level methods
//			Return Type: Data type of value returned (void if nothing returned)
//			Method Name: Identifier following naming conventions
//			Parameter List: Input parameters (optional)
//			Method Body: Code to execute

		// 1. Predefined Methods
		System.out.println(Math.max(10, 20)); // Returns maximum
		System.out.println(String.valueOf(123)); // Converts to string
		System.out.println("Hi This is Method"); // Prints to console

		// Calling a void method (return Nothing)
		printGreeting("John");
		
		// Calling a method with a return value
        int sum = addNumbers(5, 7);
        System.out.println("Sum: " + sum);

	}

	// Void method (doesn't return a value)
	public static void printGreeting(String name) {
		System.out.println("Hello, " + name + "!");
	}

	// Method returning an int
    public static int addNumbers(int a, int b) {
        return a + b;
    }
	
	
	
	
	
	
	
	
	
	// 2. User-defined Methods
	public class Calculator {
		// User-defined method
		public int add(int a, int b) {
			return a + b;
		}

	}

}
