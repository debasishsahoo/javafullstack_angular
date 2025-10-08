package MultiLevelAbstraction;

//Level 2: Partially implemented abstract class
abstract class Mammal extends Animal {
	@Override
	void sleep() {
		System.out.println("Mammal sleeps on land");
	}

	// Still abstract
	abstract void giveBirth();
}
