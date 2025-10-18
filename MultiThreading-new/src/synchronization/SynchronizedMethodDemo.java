package synchronization;

//Synchronization uses intrinsic locks (also called monitor locks) to ensure mutual exclusion
//Every Java object has an associated lock.

//How Synchronization Works
//1.Monitor Lock: Each object has one lock
//2.Acquire Lock: Thread must acquire lock before entering synchronized block
//3.Release Lock: Lock is automatically released when exiting synchronized block
//4.Mutual Exclusion: Only one thread can hold a lock at a time
//5.Blocking: Other threads wait until lock is available


//increment() is synchronized, so only one thread at a time can execute it.
//Prevents race conditions and ensures mutual exclusion.
class Counter {
	private int count = 0;

	// Synchronized instance method
	public synchronized void increment() {
		count++; // Critical section
	}

	public int getCount() {
		return count;
	}
}

public class SynchronizedMethodDemo {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100_000; i++)
				counter.increment();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100_000; i++)
				counter.increment();
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("Expected: 200000");
		System.out.println("Actual: " + counter.getCount());

	}
}
