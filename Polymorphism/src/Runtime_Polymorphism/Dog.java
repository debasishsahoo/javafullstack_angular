package Runtime_Polymorphism;

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("The dog barks: Woof! Woof!");
	}

	@Override
	public void sleep() {
		System.out.println("The dog sleeps in its bed");
	}

	// Covariant return type - returning Dog instead of Animal
	@Override
	public Dog getOffspring() {
		return new Dog();
	}

	// Dog-specific method
	public void wagTail() {
		System.out.println("The dog wags its tail");
	}
}
