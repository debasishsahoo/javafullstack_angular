package MultiLevelAbstraction;

public class Main {

	public static void main(String[] args) {
		Lion lion = new Lion();
        lion.eat();       // From Carnivore
        lion.sleep();     // From Mammal
        lion.move();      // Implemented in Lion
        lion.giveBirth(); // Implemented in Lion
        lion.hunt();      // Implemented in Lion
        lion.roar();      // Specific to Lion

	}

}
