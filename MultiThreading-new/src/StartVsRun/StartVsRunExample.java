package StartVsRun;

//What Start Do
//Creates a new thread of execution-A new call stack is created
//Registers the thread with the thread scheduler
//Invokes run() in the new thread - The run() method executes in a separate thread
//Returns immediately - The calling thread continues its execution
public class StartVsRunExample {
	public static void main(String[] args) {
		// Create a thread
		Thread t = new Thread(() -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			for (int i = 0; i < 3; i++) {
				System.out.println("Count: " + i);
//				try {
//					Thread.sleep(500); // Simulate work
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		});

		System.out.println("Before start()");

		// Start the thread (correct way)
		t.start(); // Runs in a new thread

		System.out.println("After start()");

		// Uncomment the following lines to see the difference with run()
		System.out.println("\nCalling run() directly:");
		t.run(); // Executes in main
		// thread, not a new thread System.out.println("After run()");

	}
}
