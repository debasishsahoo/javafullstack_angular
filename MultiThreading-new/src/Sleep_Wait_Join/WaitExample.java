package Sleep_Wait_Join;
//Producer thread enters the synchronized block and calls lock.wait().
//It releases the lock.
//Its state becomes WAITING.
//It remains suspended until another thread calls notify() or notifyAll() on the same lock.

//Consumer thread sleeps for 2 seconds, simulating some work.
//After waking up, it enters the synchronized block and calls lock.notify().
//This moves the waiting thread (Producer) from WAITING → RUNNABLE state.

//Producer thread resumes execution once the Consumer releases the lock (after exiting synchronized block).


//Instance method of Object class
//MUST be called within synchronized block/method - throws IllegalMonitorStateException otherwise
//Releases the lock - allows other threads to acquire it
//Must be awakened by notify()/notifyAll() or timeout
//Thread state: RUNNABLE → WAITING (or TIMED_WAITING) → RUNNABLE

public class WaitExample {
	// Shared object used for synchronization
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread producer = new Thread(() -> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + ": waiting for consumer...");
				try {
					lock.wait(); // Thread releases lock and waits
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted while waiting");
				}
				System.out.println(Thread.currentThread().getName() + ": resumed after notify");
			}
		}, "Producer");

		// Consumer thread notifies producer
		Thread consumer = new Thread(() -> {
			try {
				Thread.sleep(2000); // Simulate some work before notifying
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted during sleep");
			}

			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + ": notifying producer...");
				lock.notify(); // Wakes up producer
				System.out.println(Thread.currentThread().getName() + ": done notifying");
			}
		}, "Consumer");

		// Start threads
		producer.start();
		Thread.sleep(100); // Ensure producer starts first and waits
		consumer.start();

	}

}
