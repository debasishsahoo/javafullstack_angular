
public class Car {
	// Fields (state)
    String color;
    String model;
    int speed;
    
    // Constructor to initialize state
    Car(String color, String model, int speed) {
        this.color = color;
        this.model = model;
        this.speed = speed;
    }
    
    // Behavior: Method to accelerate the car
    void accelerate(int increment) {
        speed += increment;  // modifies the state
        System.out.println("Accelerated. Current speed: " + speed);
    }

    // Behavior: Method to brake
    void brake(int decrement) {
        speed -= decrement;  // modifies the state
        System.out.println("Slowed down. Current speed: " + speed);
    }
}

