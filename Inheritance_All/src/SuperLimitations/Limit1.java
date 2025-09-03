package SuperLimitations;

//1. Cannot use super in static context
class ParentStatic {
    String instanceField = "Parent instance field";
}

class ChildStatic extends ParentStatic {
	
	static void staticMethod() {
		System.out.println(super.instanceField);
		 System.out.println("Cannot use super in static methods");
	}
	
	
	static {
		System.out.println(super.instanceField);
		System.out.println("Cannot use super in static blocks");
	}
	
	
}



public class Limit1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
