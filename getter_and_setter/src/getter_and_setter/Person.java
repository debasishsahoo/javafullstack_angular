package getter_and_setter;
//Getter and setter methods are special methods that provide controlled access to an object's private fields.
//They're fundamental to the principle of **encapsulation** in object-oriented programming.
public class Person {
	private String name;

	// Getter method
	public String getName() {// retrieve the value of a private field:
		return name; //current state
	}

	// Setter method
	public void setName(String name) {//modify the value of a private field:
		this.name = name;
	}
}
