package AccessModifiers.defaultFolder;

//Default access class (package-private)
class Parent {
	int defaultField = 100; // default access
	String name = "Parent"; // default access

	void defaultMethod() { // default access
		System.out.println("Default method in parent");
	}

	void display() { // default access
		System.out.println("Parent display: " + defaultField);
	}
	// Parent class is package-private (no public modifier).
	// - Fields and methods are **default access**, meaning:
	// - Accessible **within the same package**.
	// - Inherited by subclasses in the **same package**.

}

class Child extends Parent {

	public void accessParentMembers() {
		// ✅ All default members are inherited and accessible
		System.out.println(defaultField); // Can access
		System.out.println(name); // Can access
		defaultMethod(); // Can call
		display();// Can call
		// ✅ Can also call parent version explicitly
		super.display();
	}
	// ✅ Can override default method
	@Override
	void display() {
		System.out.println("Child display: " + defaultField);
	}
	//- `Child` is in the **same package**, so it can access all default members of `Parent`.
	//- `display()` method is **overridden**, but you can still call the parent version using `super.display()`.
	
}

public class Scenario1 {

	public static void main(String[] args) {
		 Child child = new Child();
	        
	        // Access inherited default members
	        child.accessParentMembers();
	        
	        // Directly calling overridden display method
	        child.display();
	}

}

//- Accessible **only within the same package**.
//- Inherited by subclasses in the same package.
//- Can override default methods in subclasses.
//- Classes, methods, and fields **without an access modifier** have default/package-private access.








