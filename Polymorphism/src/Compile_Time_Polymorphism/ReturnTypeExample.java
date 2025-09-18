package Compile_Time_Polymorphism;

//Can We Overload Methods Based Only on Return Type?
//NO, you cannot overload methods based solely on return type.
//The return type is not part of the method signature used for overloading resolution.

public class ReturnTypeExample {

//	 public int getValue() {
//	        return 10;
//	    }
//	
//	 public String getValue() {  // ERROR: Duplicate method
//	        return "Hello";
//	    }
//	
	
	// Ambiguous - which getValue() should be called?
	// int result = obj.getValue();
	// String result = obj.getValue();	
	
	
	// Correct way - different parameter lists
	public int getValue() {
		return 10;
	}

	public String getValue(boolean asString) {
		return "Hello";
	}

	public static void main(String[] args) {

	}

}
