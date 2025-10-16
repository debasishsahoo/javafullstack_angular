package Q05;

public class ThreadStateNewExample {

	public static void main(String[] args) {
		// Create a thread but do not start it yet
		Thread t = new Thread(() -> {
			System.out.println("Running");
		});

		// Thread is in NEW state because start() is not called yet
		System.out.println("Thread state before start(): " + t.getState()); // Output: NEW

	}

}
