package Q10;

public class ThreadSafeCounter {
	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public synchronized void decrement() {
		count--;
	}

	public synchronized int getCount() {
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadSafeCounter counter = new ThreadSafeCounter();

		Thread[] incrementThreads = new Thread[5];
		Thread[] decrementThreads = new Thread[5];

		// Create 5 threads that increment
		for (int i = 0; i < 5; i++) {
			incrementThreads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.increment();
				}
			}, "IncrementThread-" + i);
		}

		// Create 5 threads that decrement
		for (int i = 0; i < 5; i++) {
			decrementThreads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.decrement();
				}
			}, "DecrementThread-" + i);
		}

		// Start all threads
		for (Thread t : incrementThreads)
			t.start();
		for (Thread t : decrementThreads)
			t.start();

		// Wait for all threads to finish
		for (Thread t : incrementThreads)
			t.join();
		for (Thread t : decrementThreads)
			t.join();

		System.out.println("Final count: " + counter.getCount()); // Always 0
	}
}
