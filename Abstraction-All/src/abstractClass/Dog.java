package abstractClass;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	// Implementing abstract method
	@Override
	void makeSound() {
		System.out.println(name + " says: Woof! Woof!");
	}

}
