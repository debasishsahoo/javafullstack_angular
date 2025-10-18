package Daemon;

public class DaemonInheritance {
	public static void main(String[] args) throws InterruptedException {
		// Main thread is a user thread
		System.out.println("Main is daemon? " + Thread.currentThread().isDaemon()); // false

		// Child of user thread = user thread
		Thread userChild = new Thread(() -> {
			System.out.println("User child is daemon? " + Thread.currentThread().isDaemon()); // false

			// Grandchild also inherits
			Thread grandchild = new Thread(() -> {
				System.out.println("Grandchild is daemon? " + Thread.currentThread().isDaemon()); // false
			});
			grandchild.start();
		});
		userChild.start();
		
		
		// Daemon thread
		Thread daemonParent = new Thread(() -> {
			System.out.println("Daemon parent is daemon? " + Thread.currentThread().isDaemon()); // true

			// Child of daemon = daemon
			Thread daemonChild = new Thread(() -> {
				System.out.println("Daemon child is daemon? " + Thread.currentThread().isDaemon()); // true
			});
			daemonChild.start();
		});
		daemonParent.setDaemon(true);
		daemonParent.start();

		Thread.sleep(100); // Let threads print
	}
}
