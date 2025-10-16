package Q05;

public class ThreadStateWaitingExample {
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println(Thread.currentThread().getName() + " is entering WAITING state");
					lock.wait(); // thread waits indefinitely
					System.out.println(Thread.currentThread().getName() + " resumed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread-1");

		t1.start();

		// Give t1 time to enter WAITING
		Thread.sleep(100);
		System.out.println(t1.getName() + " state: " + t1.getState()); // WAITING

		// Notify t1 to resume
		synchronized (lock) {
			lock.notify();
		}
	}
}
