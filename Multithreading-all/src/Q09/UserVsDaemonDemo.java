package Q09;

public class UserVsDaemonDemo {
	public static void main(String[] args) {
		System.out.println("=== User vs Daemon Thread Demo ===");

		// User thread: keeps JVM alive until it completes
		Thread userThread = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("User thread: Step " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("User thread completed");
		}, "UserThread");

		// Daemon thread: JVM may exit before it finishes
		Thread daemonThread = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Daemon thread: Step " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Daemon thread completed"); // May never print
		}, "DaemonThread");

		daemonThread.setDaemon(true); // Mark as daemon

		// Start both threads
		userThread.start();
		daemonThread.start();

		System.out.println("Main thread ending");
	}
}
