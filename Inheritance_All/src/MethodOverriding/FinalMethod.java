package MethodOverriding;

//Parent class
class Parent3 {
	public final void finalMethod() {
		System.out.println("Cannot be overridden");
	}
}

//Child class
class Child3 extends Parent3 {

	// ❌ Compilation Error: //
	// "finalMethod() in Child cannot override finalMethod() in Parent" public void
	@Override
	public final void finalMethod() { System.out.println("Trying to override"); }

}

public class FinalMethod {

	public static void main(String[] args) {
		Parent3 p = new Parent3();
		Child3 c = new Child3();

		p.finalMethod(); // Output: Cannot be overridden
		c.finalMethod(); // Output: Cannot be overridden
	}

}


//- **`final` method** → cannot be overridden in subclasses.
//- Subclasses can still **inherit and use** the method.
//- Useful for:
//    - Preventing modification of critical methods (e.g., `Object.wait()`, `Object.equals()` in some cases).
//    - Ensuring a specific behavior remains unchanged across subclasses.




