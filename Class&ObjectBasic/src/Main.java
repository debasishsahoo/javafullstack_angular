
public class Main {
	public static void main(String[] args) {
        Car myCar1 = new Car("Red", "Toyota", 100);
        System.out.println("Car color: " + myCar1.color);
        System.out.println("Car speed: " + myCar1.speed);
        
        
        
        
        
        
        
        
        
        
        
        
        myCar1.accelerate(20);  // behavior changes state
        myCar1.brake(30);       // behavior changes state
        
        
        
        Car myCar2 = new Car("Blue", "Jeep", 120);
        System.out.println("Car color: " + myCar2.color);
        System.out.println("Car speed: " + myCar2.speed);
        
        myCar2.accelerate(50);  // behavior changes state
        myCar2.brake(40);       // behavior changes state
        
        
        //accelerate() and brake() define behavior.
        //These methods modify the object's state (speed).
        
        //State = What an object knows; 
        //Behavior = What an object can do.
        
    }
}

//Here, the state of myCar is:
// color="Red"
// model="Toyota"
// speed=100