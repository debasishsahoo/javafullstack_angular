package MethodOverriding;

//Parent class
class Parent2 {
	public static void staticMethod() {
		System.out.println("Parent static");
	}
}

//Child class
class Child2 extends Parent2 {
	// This hides, does not override
	public static void staticMethod() {
		System.out.println("Child static");
	}
}

public class StaticMethods {

	public static void main(String[] args) {
		Parent2 p = new Parent2();
		Parent2 c = new Child2(); // Parent reference to Child object
		
		
		Child2 realChild = new Child2();

		// Calls depend on reference type, not object type
		p.staticMethod(); // Output: Parent static
		c.staticMethod(); // Output: Parent static (not polymorphic!)
		realChild.staticMethod(); // Output: Child static
	}

}

//Static methods cannot be overridden, only hidden.

//- **Static methods are resolved at compile time** → based on the **reference type**, not the actual object.
//- That’s why `c.staticMethod()` (where `c` is a `Parent` reference) calls **Parent’s method**, even though the object is a `Child`.
//- This is called **method hiding**, not overriding.
//- Only **instance methods** (non-static) exhibit **runtime polymorphism** in Java.








