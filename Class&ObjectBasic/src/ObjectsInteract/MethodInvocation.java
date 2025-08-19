package ObjectsInteract;

class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    Engine engine = new Engine(); // Car has-a Engine
    
    void startCar() {
        engine.start(); // Object interaction
        System.out.println("Car is running.");
    }
}


public class MethodInvocation {
	public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startCar(); // Car interacts with Engine
    }
}
//Car interacts with Engine by calling its start() method.
//This is a “has-a” relationship (composition).