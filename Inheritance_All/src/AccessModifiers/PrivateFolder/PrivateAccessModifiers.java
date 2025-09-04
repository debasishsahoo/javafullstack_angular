package AccessModifiers.PrivateFolder;

class Parent {
	private String privateField = "Private data";

	private void privateMethod() {
		System.out.println("Private method in Parent");
	}

	public void accessPrivateFromParent() {
		// Parent class can access its own private members
		System.out.println("Parent accessing: " + privateField);
		privateMethod();
	}
}

class Child extends Parent {
	public void tryAccess() {
		// ❌ The following would cause compilation errors:
		// System.out.println(privateField);
		// privateMethod();

		// ✅ But we can call public/protected methods from Parent
		System.out.println("Child cannot access Parent's private members directly.");
		accessPrivateFromParent();
	}
}

public class PrivateAccessModifiers {

	public static void main(String[] args) {
		Child obj = new Child();
		obj.tryAccess();
	}

}
