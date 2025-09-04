package MethodOverriding;

class Parent1 {
	protected void method() { // protected access
		System.out.println("Parent method");
	}
}

class Child1 extends Parent1 {
	// ❌ This would cause a compile-time error:
	// Cannot reduce the visibility of the inherited method
	// @Override
	// private void method() {
	// System.out.println("Invalid override");
	// }

	@Override
	public void method() { // public is allowed (less restrictive)
		System.out.println("Child method");
	}

}

public class Rule2 {
	public static void main(String[] args) {
		Parent1 parentObj = new Parent1();
		Parent1 childObj = new Child1(); // Polymorphism

		parentObj.method(); // Output: Parent method
		childObj.method(); // Output: Child method
	}
}




//
//- A child class **can increase visibility** of the overridden method (`protected → public` ✅).
//- A child class **cannot decrease visibility** (`protected → private` ❌).
//- This ensures the overridden method remains accessible where the parent’s method is accessible (or more).











