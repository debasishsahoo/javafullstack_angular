package Sleep_Wait_Join;
//Scenario 1: sleep() (KEEPS the lock)

//sleepThread acquires the lock and calls Thread.sleep(7000).
//While it’s sleeping, it still owns the lock.
//blockedThread tries to enter the synchronized block but can’t — it’s BLOCKED.
//After 7 seconds, sleepThread wakes up and exits the synchronized block.
//blockedThread finally acquires the lock and continues execution.

//Scenario 2: wait() (RELEASES the lock)
//waitThread acquires the lock, then calls lock.wait(6000).
//wait() immediately releases the lock and goes into TIMED_WAITING.
//blockedThread can now acquire the lock right away.
//After 6 seconds, waitThread wakes up, re-acquires the lock, and continues.

//- sleep() is like pause but hold on to your seat — no one else can sit.
//- wait() is like pause and give up your seat — others can take it until you’re notified to continue.

public class LockBehavior {
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		// Thread 1: Uses sleep() → holds the lock
		Thread sleepThread = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Sleep: Acquired lock");
				try {
					Thread.sleep(7000); // Holds lock for 2 seconds
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
					lock.wait(6000); // Releases lock immediately
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

//		// Run scenario 2: wait() releases lock
		System.out.println("\n--- Scenario 2: wait() releases the lock ---");
		waitThread.start();
		Thread.sleep(100); // ensure waitThread acquires lock first
		blockedThread.start();
		waitThread.join();
		blockedThread.join();

	}

}
