package debugCode;
class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println("Vehicle starting");
    }

    public String getType() {
        return type;
    }
}

class Car extends Vehicle {
    private int horsepower;

    public Car(int horsepower) {
        //Since the Car class does not have a type field,
        super("car"); // Fixed: Call superclass constructor
        this.horsepower = horsepower;
    }

    @Override
    public void start() {
    	super.start(); // Proper use of super
        System.out.println("Car with " + horsepower + " HP starting");
    }

    public void turboBoost() {
        System.out.println("Turbo activated!");
    }
}


public class Main1 {

	 public static void main(String[] args) {
	        Vehicle v = new Car(200);
	        v.start();
	        
	        //Must be downcast
	        //v.turboBoost();
	        // Fixed: Use type casting to access subclass method
	        if (v instanceof Car) {
	        	((Car) v).turboBoost();
	        }
	        
	        System.out.println("Type: " + v.getType());
	    }

}
