package Q7;

public class LockBehavior {
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		// Thread 1: Uses sleep() → holds the lock
		Thread sleepThread = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Sleep: Acquired lock");
				try {
					Thread.sleep(2000); // Holds lock for 2 seconds
				} catch (InterruptedException e) {
					System.out.println("Sleep: Interrupted");
				}
				System.out.println("Sleep: Releasing lock");
			}
		});

		// Thread 2: Uses wait() → releases the lock
		Thread waitThread = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Wait: Acquired lock");
				try {
					lock.wait(2000); // Releases lock immediately
				} catch (InterruptedException e) {
					System.out.println("Wait: Interrupted");
				}
				System.out.println("Wait: Re-acquired lock after wait");
			}
		});

		// Thread 3: Competes for the same lock
		Thread blockedThread = new Thread(() -> {
			System.out.println("Blocked: Trying to acquire lock...");
			synchronized (lock) {
				System.out.println("Blocked: Finally acquired lock!");
			}
		});

		// Run scenario 1: sleep() holds lock
		System.out.println("\n--- Scenario 1: sleep() holds the lock ---");
		sleepThread.start();
		Thread.sleep(100); // ensure sleepThread acquires lock first
		blockedThread.start();
		sleepThread.join();
		blockedThread.join();

		// Run scenario 2: wait() releases lock
		System.out.println("\n--- Scenario 2: wait() releases the lock ---");
		waitThread.start();
		Thread.sleep(100); // ensure waitThread acquires lock first
		blockedThread = new Thread(() -> {
			System.out.println("Blocked: Trying to acquire lock...");
			synchronized (lock) {
				System.out.println("Blocked: Finally acquired lock!");
			}
		});
		blockedThread.start();

		waitThread.join();
		blockedThread.join();
	}
}
