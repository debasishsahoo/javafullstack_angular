package project_1;

abstract class Animal {
	protected String name;
	protected int age;

	// Constructor for abstract class
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Concrete method - shared implementation
	public void sleep() {
		System.out.println(name + " is sleeping...");
	}

	// Concrete method with common behavior
	public String getInfo() {
		return "Name: " + name + ", Age: " + age;
	}

	// Abstract method - must be implemented by subclasses
	public abstract void makeSound();

	// Abstract method for movement
	public abstract void move();

	// Abstract method for feeding
	public abstract void eat(String food);

}
