package MethodOverriding;

class Vehicle {
	public void start() {
		System.out.println("Vehicle starting");
	}
}

//Child class
class Car extends Vehicle {
	@Override
	public void start() { // Correct overriding
		System.out.println("Car engine starting");
	}
	/*
	 * @Override public void stat() { // ❌ Compilation error // Reason: 'stat()'
	 * does not match any method in parent
	 * System.out.println("Typo in method name"); }
	 */
}

public class Rule4 {
	public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();

        v1.start(); // Output: Vehicle starting
        v2.start(); // Output: Car engine starting
    }
}




//The `@Override` annotation is recommended because it:
//
//- Ensures you're actually overriding (catches typos)
//- Makes code more readable and maintainable
//- Provides compile-time checking
//
//- Without `@Override`, Java will silently treat `stat()` as a **new method** in `Car`.
//- With `@Override`, the **compiler checks correctness**:
//    - If the parent does not have a matching method signature, you’ll get a **compile-time error**.
//    - This helps catch mistakes like **typos, wrong parameters, or wrong return types**.














