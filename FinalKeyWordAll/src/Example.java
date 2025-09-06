
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

public class Example {
	final int a = 10; // Direct initialization
	final int b; // Constructor initialization
	static final int c; // Static block initialization

	static {
		c = 30; // Static block
	}

	public Example() {
		b = 20; // Constructor
		// c = 30; Only Static Block
	}

	public static void main() {
		Car1 c1 = new Car1();
		
		c1.accessMethod();

	}

}
