package abstractClass;

//Abstract class
public abstract class Animal {
	// Instance variable
	String name;

	// Constructor
	public Animal(String name) {
		this.name = name;
	}

	// Abstract method (no implementation)
	abstract void makeSound();

	// Concrete method (with implementation)
	public void sleep() {
		System.out.println(name + " is sleeping...");
	}

	// Another concrete method
	public void eat() {
		System.out.println(name + " is eating...");
	}
}
