package Q7;

public class WaitExample {
	// Shared object used for synchronization
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		// Producer thread waits for the consumer to notify
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
