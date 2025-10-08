package MultiLevelAbstraction;

//Level 3: Another abstract class
abstract class Carnivore extends Mammal {
	@Override
	void eat() {
		System.out.println("Eats meat");
	}

	// New abstract method
	abstract void hunt();
}
