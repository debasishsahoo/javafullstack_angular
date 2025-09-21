package FunctionalInterface;


@FunctionalInterface
public interface Greeter {
	 void greet(String name);
	
	// Default method
    default void sayHello() {
        System.out.println("Hello from default method!");
    }

    // Static method
    static void info() {
        System.out.println("This is a Functional Interface Example");
    }
}
