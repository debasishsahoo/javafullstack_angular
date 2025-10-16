package Q09;

public class GarbageCollectorDaemonDemo {
	public static void main(String[] args) {
		System.out.println("=== Simulated Garbage Collector Daemon ===");

		// Simulated GC running as a daemon thread
		Thread gcThread = new Thread(() -> {
			while (true) {
				System.out.println("Garbage Collector: Cleaning up memory...");
				try {
					Thread.sleep(1000); // Pause to simulate work
				} catch (InterruptedException e) {
					System.out.println("GC thread interrupted");
					break;
				}
			}
		}, "GCThread");

		gcThread.setDaemon(true); // Must be a daemon
		gcThread.start();

		// Main thread simulating application work
		for (int i = 1; i <= 5; i++) {
			System.out.println("Application working: Step " + i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
		}

		System.out.println("Main thread ending. JVM will terminate daemon threads.");
	}
}
