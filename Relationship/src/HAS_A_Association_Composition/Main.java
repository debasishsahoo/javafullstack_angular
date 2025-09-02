package HAS_A_Association_Composition;

public class Main {
	public static void main(String[] args) {
		Car myCar = new Car("Toyota", "V12");
		myCar.drive();
		// The Car's engine is created with the car and dies with the car.
	}
}
