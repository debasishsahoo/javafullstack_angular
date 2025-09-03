package SuperRules;

//Rule 3: super cannot be used in static methods or static blocks
class Parent3 {
	String instanceField = "Parent instance field";
	static String staticField = "Parent static field";
}

class Child3 extends Parent3 {
	static void staticMethod() {
		System.out.println(super.instanceField); // Error: cannot use super in static context
		System.out.println("Accessing static field: " + staticField);// OK (inherited static field)
		System.out.println("Accessing static field: " + super.staticField);
	}
}

public class Rule3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
