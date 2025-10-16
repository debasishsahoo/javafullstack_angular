package Q05;

public class ThreadStateRunnableExample {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("Thread is running...");
			try {
				Thread.sleep(1000); // simulate work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println("State before start(): " + t.getState()); // Output: NEW

		t.start(); // Moves thread to RUNNABLE state
		System.out.println("State after start(): " + t.getState()); // Output: RUNNABLE

		try {
			t.join(); // Wait for thread to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
