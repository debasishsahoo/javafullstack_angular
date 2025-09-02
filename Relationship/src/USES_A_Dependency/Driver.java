package USES_A_Dependency;

class Driver {
	private String name;

	Driver(String name) {
		this.name = name;
	}

	// Dependency: The drive() method USES-A Car object
	void drive(Car car) { // Car is passed as a parameter (dependency)
		System.out.print(name + " is ");
		car.drive(); // Using the car temporarily
	}

}
