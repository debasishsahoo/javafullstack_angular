package USES_A_Dependency;

public class Main {
	public static void main(String[] args) {
		Car myCar = new Car("Toyota", "V12");
		Driver driver = new Driver("Alice");

		driver.drive(myCar); // Alice uses the car for a task
	    // The Driver object does not contain the Car as a field.
	}
}
