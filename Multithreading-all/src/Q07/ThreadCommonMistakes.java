package Q07;

public class ThreadCommonMistakes {

	private static final Object lock = new Object();
	private static boolean condition = false;

	// Dummy method to simulate writing to a file
	static void writeToFile() {
		System.out.println(Thread.currentThread().getName() + ": Writing to file...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": Write complete.");
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Mistake 1: Calling wait() without synchronization ===");

		try {
			// WRONG — calling wait() without synchronized block
			lock.wait(); // Throws IllegalMonitorStateException
		} catch (IllegalMonitorStateException e) {
			System.out.println("Error: " + e);
		}

		// CORRECT — use synchronized block
		synchronized (lock) {
			System.out.println("Inside synchronized block before wait()");
			lock.wait(500); // Waiting for 0.5 second safely
			System.out.println("Exited wait() correctly inside synchronized block");
		}

		System.out.println("\n=== Mistake 2: Using sleep() when wait() is needed ===");

		// WRONG — Using sleep() while holding lock (wastes CPU and blocks others)
		Thread wrongSleep = new Thread(() -> {
			synchronized (lock) {
				while (!condition) {
					try {
						System.out.println("Using sleep() — holding lock, wasting CPU...");
						Thread.sleep(500); // Keeps lock and CPU busy
						condition = true; // Simulate condition update
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Condition met after sleep().");
			}
		});

		// CORRECT — Using wait() (efficient, releases lock)
		Thread correctWait = new Thread(() -> {
			synchronized (lock) {
				while (!condition) {
					try {
						System.out.println("Using wait() — releasing lock efficiently...");
						lock.wait(500); // Releases lock temporarily
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Condition met after wait().");
			}
		});

		wrongSleep.start();
		wrongSleep.join(); // Wait until the "sleep" version finishes
		condition = false; // Reset for next test

		correctWait.start();
		correctWait.join();

		System.out.println("\n=== Mistake 3: Forgetting to call join() ===");

		// WRONG — main may close file before writing completes
		Thread writer1 = new Thread(() -> writeToFile());
		writer1.start();
		System.out.println("Main (wrong): Closing file too soon (might interrupt write)");

		// Wait for demonstration clarity
		Thread.sleep(1500);

		// CORRECT — use join() to ensure completion
		Thread writer2 = new Thread(() -> writeToFile());
		writer2.start();
		writer2.join(); // Wait for writer2 to finish
		System.out.println("Main (correct): File safely closed after writing completed.");
	}
}
