package Q09;

public class MonitoringService {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Monitoring Service with Daemon Thread ===");

		// Daemon thread to monitor system status
		Thread monitor = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread().getName() + " - System status: OK");
				System.out.println(Thread.currentThread().getName() + " - Free Memory: "
						+ Runtime.getRuntime().freeMemory() / 1024 + " KB");
				try {
					Thread.sleep(5000); // Monitor every 5 seconds
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted");
					break;
				}
			}
		});

		monitor.setDaemon(true); // Must be set before start
		monitor.setName("SystemMonitor"); // Optional naming
		monitor.start();

		// Simulate main application work
		System.out.println("Application running...");
		Thread.sleep(12000); // Run for 12 seconds
		System.out.println("Application shutting down...");

		// Daemon monitor thread stops automatically when main exits
	}
}
