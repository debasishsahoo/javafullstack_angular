package MethodOverriding;

//Parent class
class Parent {
	public void display(String message) {
		System.out.println("Parent: " + message);
	}
}

//Child class overriding the method
class Child extends Parent {
	// @Override
	// protected void display(String message) {} //Cannot reduce the visibility of
	// the inherited method from Parent
	// public int display(String message) {} //The return type is incompatible with
	// Parent.display(String)
	// public void display(int message) {}//The method display(int) of type Child
	// must override or implement a supertype method
	@Override
	public void display(String message) {
		System.out.println("Child: " + message);
	}

}

public class Rule1 {
	public static void main(String[] args) {
		Parent parentObj = new Parent();
		Parent childObj = new Child();
		

		parentObj.display("Hello from Parent"); // Output: Parent: Hello from Parent
		childObj.display("Hello from Child"); // Output: Child: Hello from Child
		
	}

}

//
//- Both `Parent` and `Child` have a method `display(String message)` with the **same signature**.
//- The `@Override` annotation ensures correctness (compiler error if method signature doesn’t match).
//- **Polymorphism in action**:
//    - When called on `parentObj` → executes parent’s version.
//    - When called on `childObj` (but reference is `Parent`) → executes child’s version at **runtime**.



