package Runtime_Polymorphism;

class Animal {
	public void makeSound() {
		System.out.println("The animal makes a sound");
	}

	public void sleep() {
		System.out.println("The animal is sleeping");
	}

	// Method that returns Animal type
	public Animal getOffspring() {
		return new Animal();
	}
}
