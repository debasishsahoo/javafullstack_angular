package Q09;

public class DaemonInterruptDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Daemon Thread Interrupt Handling Demo ===");

		Thread daemon = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					performTask();
					Thread.sleep(1000); // Simulate periodic work
				} catch (InterruptedException e) {
					System.out.println("Daemon interrupted! Exiting cleanly.");
					Thread.currentThread().interrupt(); // Restore interrupt status
					break; // Exit loop
				}
			}
		}, "InterruptibleDaemon");

		daemon.setDaemon(true);
		daemon.start();

		// Let daemon run for 3 seconds
		Thread.sleep(3000);
		System.out.println("Main thread exiting, daemon will terminate");
	}

	private static void performTask() {
		System.out.println(Thread.currentThread().getName() + " performing task...");
	}
}
