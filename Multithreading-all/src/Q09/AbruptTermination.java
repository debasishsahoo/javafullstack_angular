package Q09;

public class AbruptTermination {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Abrupt Termination Demo ===");

		Thread daemon = new Thread(() -> {
			try {
				System.out.println("Daemon: Starting critical operation");
				Thread.sleep(2000); // Simulate long task
				System.out.println("Daemon: Operation complete"); // Likely won't print
			} catch (InterruptedException e) {
				System.out.println("Daemon: Interrupted");
			}
		}, "CriticalDaemon");

		daemon.setDaemon(true); // Mark as daemon
		daemon.start();

		// Main thread simulates short work
		Thread.sleep(500);
		System.out.println("Main: Exiting");
		// JVM shuts down immediately, daemon may not finish its task
	}
}
