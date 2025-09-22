package DMD;

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Dog barks: Woof!");
	}

	public void fetch() {
		System.out.println("Dog fetches the ball");
	}
}
