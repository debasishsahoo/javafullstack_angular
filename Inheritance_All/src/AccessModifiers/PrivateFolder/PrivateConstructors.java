package AccessModifiers.PrivateFolder;

class NonInheritable {
	// Private constructor prevents inheritance
	private NonInheritable() {
		System.out.println("NonInheritable constructor called");
	}

	// We can still provide a factory method to create instances
	public static NonInheritable createInstance() {
		return new NonInheritable();
	}

}
//❌ This would cause a compilation error because constructor is private
//class Child extends NonInheritable { } 



public class PrivateConstructors {

	public static void main(String[] args) {
		 // You cannot directly do: new NonInheritable();  // ❌ Compilation error
		NonInheritable ni = NonInheritable.createInstance();
		System.out.println("Object created using factory method: " + ni);

	}

}
