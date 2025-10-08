package abstractClass;

public class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}

	// Implementing abstract method
	@Override
	void makeSound() {
		System.out.println(name + " says: Meow! Meow!");
	}
}
