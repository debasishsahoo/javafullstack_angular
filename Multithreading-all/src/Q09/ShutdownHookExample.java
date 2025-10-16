package Q09;

public class ShutdownHookExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Shutdown Hook with Daemon Thread Demo ===");

		// Register a shutdown hook (user thread)
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutdown hook executed");
		}));

		// Daemon thread simulating background work
		Thread daemon = new Thread(() -> {
			while (true) {
				System.out.println("Daemon working...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
		}, "BackgroundDaemon");

		daemon.setDaemon(true); // Daemon thread
		daemon.start();

		// Main thread simulates work
		Thread.sleep(2500);
		System.out.println("Main exiting");
		// JVM runs shutdown hooks but daemon thread terminates immediately
	}
}
