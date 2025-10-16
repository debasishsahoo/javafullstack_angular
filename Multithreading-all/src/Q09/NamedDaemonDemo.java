package Q09;

public class NamedDaemonDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Named Daemon Thread Demo ===");

		Thread daemon = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + " working... " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					break;
				}
			}
		});

		daemon.setDaemon(true); // Make it a daemon
		daemon.setName("BackgroundCleaner"); // Set a descriptive name
		daemon.start();

		// Main thread simulates work
		Thread.sleep(1500);
		System.out.println("Main thread exiting");
	}
}
