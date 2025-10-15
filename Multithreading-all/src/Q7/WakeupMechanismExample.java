package Q7;

public class WakeupMechanismExample {

	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		// Example 1: sleep() - wakes up automatically
		Thread sleepThread = new Thread(() -> {
			System.out.println("sleepThread: Started at " + System.currentTimeMillis());
			try {
				Thread.sleep(2000); // Pauses for 2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("sleepThread: Woke up automatically at " + System.currentTimeMillis());
		});

		// Example 2: wait() - must be notified
		Thread waitThread = new Thread(() -> {
			synchronized (lock) {
				System.out.println("waitThread: Waiting for notification...");
				try {
					lock.wait(); // Releases lock and waits indefinitely
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("waitThread: Woken up after notify()");
			}
		});

		Thread notifierThread = new Thread(() -> {
			try {
				Thread.sleep(3000); // Simulate delay before notifying
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (lock) {
				System.out.println("notifierThread: Sending notification...");
				lock.notify(); // Wakes up waiting thread
			}
		});

		// Example 3: join() - wakes up when thread finishes
		Thread joinTarget = new Thread(() -> {
			System.out.println("joinTarget: Doing work...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("joinTarget: Finished work");
		});

		Thread joinThread = new Thread(() -> {
			try {
				System.out.println("joinThread: Waiting for joinTarget to finish...");
				joinTarget.join(); // Waits until joinTarget finishes
				System.out.println("joinThread: joinTarget completed, resuming...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// Start all examples
		System.out.println("=== Demonstrating sleep(), wait(), and join() ===\n");

		sleepThread.start();

		Thread.sleep(100); // Ensure sequence clarity
		waitThread.start();
		notifierThread.start();

		Thread.sleep(100); // Small delay before join example
		joinTarget.start();
		joinThread.start();
	}
}
