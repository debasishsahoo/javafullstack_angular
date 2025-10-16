package lifecycle;

public class ThreadTerminatedExample {
	public static void main(String[] args) throws InterruptedException {
		// Create a new thread
		Thread t = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": Task completed");
		}, "MyThread");

		
		// Thread is in NEW state before start
		System.out.println(t.getName() + " state before start(): " + t.getState()); // NEW

		// Start the thread (moves to RUNNABLE state)
		t.start();

		// Wait for the thread to complete
		t.join();

		// After completion, thread is in TERMINATED state
		System.out.println(t.getName() + " state after completion: " + t.getState()); // TERMINATED

		// Attempting to restart a terminated thread will throw an exception
		 t.start(); // Uncommenting this line will throw IllegalThreadStateException
	}
}
