
class Vehicle {
	final void startEngine() {
		System.out.println("Engine from Vehicle");
	} // Cannot override
}
class Car extends Vehicle {
	// @Override
	// void startEngine() { }
}

final class Car1 extends Vehicle {

	void accessMethod() {
		startEngine();
	}

}

class Example {
    // final variables
    final int instanceValue;        // Must be set in constructor
    static final double PI = 3.14159; // Constant

    // static variable
    static int counter = 0;

    Example(int value) {
        instanceValue = value; // constructor initialization
        counter++;             // shared among all objects
    }

    final void cannotOverride() {
        System.out.println("This method cannot be overridden");
    }

    static void staticMethod() {
        System.out.println("Static method called");
    }

    public static void main(String[] args) {
        Example e1 = new Example(10);
        Example e2 = new Example(20);

        System.out.println("PI = " + Example.PI);
        System.out.println("Counter = " + Example.counter);
        System.out.println("e1.instanceValue = " + e1.instanceValue);
        System.out.println("e2.instanceValue = " + e2.instanceValue);

        Example.staticMethod();
    }
}

