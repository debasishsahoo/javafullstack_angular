package USES_A_Dependency;

class Car {
	 private String model;
	// Composition: Car HAS-A Engine, and it's created inside Car.
	 private Engine engine; // The engine is part of the car
	 
	 
	 
	 
	 Car(String model, String engineType) {
	        this.model = model;
	        this.engine = new Engine(engineType); // Engine is created here
	    }
	 
	 void drive() {
	        engine.start();
	        System.out.println(model + " is driving.");
	    }
	 
	 
	 
}
