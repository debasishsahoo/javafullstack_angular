package InterffaceDem02;

interface Vehicle {
	void start(); // abstract method

	default void stop() {
		System.out.println("Vehicle stopped");
	}

	static void service() {
		System.out.println("Vehicle servicing...");
	}
}
