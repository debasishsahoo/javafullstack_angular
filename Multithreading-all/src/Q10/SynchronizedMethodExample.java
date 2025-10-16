package Q10;

public class SynchronizedMethodExample {
	private int counter = 0;
	// Synchronized instance method
	public synchronized void increment() {
		counter++;
	}
	// Equivalent to:
	public void incrementExplicit() {
		synchronized (this) {
			counter++;
		}
	}
	public synchronized int getCounter() {
		return counter;
	}
	public static void main(String[] args) throws InterruptedException {
		SynchronizedMethodExample obj = new SynchronizedMethodExample();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				obj.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				obj.increment();
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("Counter: " + obj.getCounter()); // Always 200000
	}

}
