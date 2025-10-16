package Q09;

public class FinallyNotGuaranteed {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Finally Block in Daemon Thread Demo ===");

		Thread daemon = new Thread(() -> {
			try {
				while (true) {
					System.out.println("Daemon working...");
					Thread.sleep(500);
				}
			} finally {
				System.out.println("Daemon finally block executed"); // May never run
			}
		}, "WorkerDaemon");

		daemon.setDaemon(true); // Mark as daemon
		daemon.start();

		// Main thread simulates short work
		Thread.sleep(1500);
		System.out.println("Main exiting");
		// JVM terminates daemon threads immediately, skipping finally
	}
}
