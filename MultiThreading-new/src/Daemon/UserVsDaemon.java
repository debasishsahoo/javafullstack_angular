package Daemon;

//daemon thread is a low-priority
// run on background 
//provides services to user threads
//When all user threads have finished execution the JVM automatically terminates.
//even if the daemon threads are still running.
//Used for supporting tasks like garbage collection, monitoring, cleanup
public class UserVsDaemon {

	public static void main(String[] args) {
		System.out.println("=== User vs Daemon Thread Demo ===");

		Thread userThread = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("User thread: Step " + i + " " + System.currentTimeMillis());
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
				System.out.println("Daemon thread: Step " + i + " " + System.currentTimeMillis());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Daemon thread completed"); // May never print
		}, "DaemonThread");

		// Check default daemon status
        System.out.println("Before setDaemon: " + daemonThread.isDaemon()); // false
		
		daemonThread.setDaemon(true); // Mark as daemon(must be done before start)
		
		// Check daemon status after setting
        System.out.println("After setDaemon: " + daemonThread.isDaemon());  // true

		// Start both threads
		userThread.start();
		daemonThread.start();

		System.out.println("Main thread ending");

	}

}
