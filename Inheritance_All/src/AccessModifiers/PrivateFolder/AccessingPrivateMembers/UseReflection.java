package AccessModifiers.PrivateFolder.AccessingPrivateMembers;

//Using Reflection (Not Recommended)
import java.lang.reflect.Field;

//Parent class with a private field
class Parent1 {
	private String privateField = "This is private";

	// Optional: normal getter method
	protected String getPrivateField() {
		return privateField;
	}
}

//Child class trying to access Parent's private field via reflection
class Child1 extends Parent1 {

	public void accessViaReflection() {
		try {
			// Get the private field from Parent class
			Field field = Parent1.class.getDeclaredField("privateField");

			// Make it accessible
			field.setAccessible(true); // Breaks encapsulation

			// Get the value of the field for the current instance
			String value = (String) field.get(this);
			System.out.println("Accessed via reflection: " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

public class UseReflection {

	public static void main(String[] args) {
		Child1 child = new Child1();

		// Access using normal method
		System.out.println("Accessed via getter: " + child.getPrivateField());

		// Access via reflection
		child.accessViaReflection();

	}

}
