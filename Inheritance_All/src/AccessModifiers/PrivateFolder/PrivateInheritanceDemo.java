package AccessModifiers.PrivateFolder;

class Parent1 {
	private String privateData = "Original private data";
	private int privateCounter = 0;

	// Public methods to access private members
	public String getPrivateData() {
		return privateData;
	}

	public void setPrivateData(String value) {
		this.privateData = value;
	}

	public int getPrivateCounter() {
		return privateCounter;
	}

	public void incrementCounter() {
		this.privateCounter++;
	}

	// Method that uses private members internally
	public String getStatus() {
		return "Data: " + privateData + ", Count: " + privateCounter;
	}
}

class Child1 extends Parent1 {
	// Child class cannot directly access Parent's private members
	// but can use the public methods to interact with them
	public void demonstratePrivateMembersExist() {
		System.out.println("Initial state: " + getStatus());

		// Access private data through public methods
		System.out.println("Private data via getter: " + getPrivateData());
		System.out.println("Private counter via getter: " + getPrivateCounter());

		// Modify private data through public methods
		setPrivateData("Modified by Child class");
		incrementCounter();
		incrementCounter();

		System.out.println("After modification: " + getStatus());

		// Show that the private data maintains state
		for (int i = 0; i < 3; i++) {
			incrementCounter();
		}
		System.out.println("After more increments: " + getStatus());
	}

}

public class PrivateInheritanceDemo {
	public static void main(String[] args) {
		Child1 c1 = new Child1();
		c1.demonstratePrivateMembersExist();

		// Create another instance to show state is separate
		Child1 c2 = new Child1();
		System.out.println("\nSecond instance - Initial state: " + c2.getStatus());
		c2.setPrivateData("Different data in second instance");
		System.out.println("Second instance - After change: " + c2.getStatus());

		// Show first instance state is unchanged (proving separate memory allocation)
		System.out.println("\nFirst instance state is preserved: " + c1.getStatus());

	}
}
