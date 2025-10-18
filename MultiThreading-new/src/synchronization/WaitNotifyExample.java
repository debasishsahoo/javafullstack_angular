package synchronization;

public class WaitNotifyExample {
	private final Object lock = new Object();
	private boolean ready = false;

	public void waitForSignal() {
		synchronized (lock) {
			while (!ready) {
				try {
					System.out.println("Waiting...");
					lock.wait(); // Releases lock and waits
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println("Received signal!");
		}
	}

	public void sendSignal() {
		synchronized (lock) {
			ready = true;
			System.out.println("Sending signal...");
			lock.notifyAll(); // Wake up waiting threads
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WaitNotifyExample example = new WaitNotifyExample();

		Thread waiter = new Thread(() -> example.waitForSignal());
		waiter.start();

		Thread.sleep(2000); // Let waiter start waiting

		Thread notifier = new Thread(() -> example.sendSignal());
		notifier.start();
	}

}
