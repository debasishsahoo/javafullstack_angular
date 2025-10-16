package Q09;

public class DaemonSetBeforeStart {
	public static void main(String[] args) {
		System.out.println("=== Daemon Thread: Set Before Start ===");

		// CORRECT way
		Thread correctThread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " is daemon? " + Thread.currentThread().isDaemon());
		}, "CorrectDaemonThread");

		correctThread.setDaemon(true); // Must be before start
		correctThread.start();

		// WRONG way - will throw IllegalThreadStateException
		Thread wrongThread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " running...");
		}, "WrongDaemonThread");

		wrongThread.start(); // Start first

		try {
			wrongThread.setDaemon(true); // IllegalThreadStateException
		} catch (IllegalThreadStateException e) {
			System.out.println("Exception caught: Cannot set daemon after start!");
		}
	}
}
