package project_1;

class Bird extends Animal{
	private boolean canFly;

	public Bird(String name, int age, boolean canFly) {
		super(name, age);
		this.canFly = canFly;
	}

	@Override
	public void makeSound() {
		System.out.println(name + " chirps: Tweet! Tweet!");
	}
	@Override
	public void move() {
		if (canFly) {
			System.out.println(name + " flies through the air");
		} else {
			System.out.println(name + " hops on the ground");
		}
	}

	@Override
	public void eat(String food) {
		System.out.println(name + " pecks at " + food);
	}

	// Bird-specific method
	public void buildNest() {
		System.out.println(name + " builds a cozy nest");
	}
}
