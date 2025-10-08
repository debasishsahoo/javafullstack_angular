package MultiLevelAbstraction;

//Level 4: Concrete implementation
public class Lion extends Carnivore {
	@Override
	void move() {
		System.out.println("Lion runs on four legs");
	}

	@Override
	void giveBirth() {
		System.out.println("Lion gives birth to live cubs");
	}

	@Override
	void hunt() {
		System.out.println("Lion hunts in pride");
	}

	// Additional method specific to Lion
	void roar() {
		System.out.println("Lion roars loudly!");
	}
}
