package downcasting;

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Woof!");
	}

	public void wagTail() {
		System.out.println("Wagging tail");
	}
}
