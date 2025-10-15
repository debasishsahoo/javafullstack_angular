package Q8;

public class ThreadPriorityExample {

	public static void main(String[] args) {
		System.out.println("=== Thread Priority Example ===");

		// Thread 1 - default priority
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " running with priority "
					+ Thread.currentThread().getPriority());
		}, "Thread-1");

		
		// Thread 2 - maximum priority
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " running with priority "
					+ Thread.currentThread().getPriority());
		}, "Thread-2");

		
		// Thread 3 - minimum priority
		Thread t3 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " running with priority "
					+ Thread.currentThread().getPriority());
		}, "Thread-3");

		
		// Setting priorities (1 = MIN, 5 = NORM, 10 = MAX)
		t1.setPriority(Thread.NORM_PRIORITY); // Default (5)
		t2.setPriority(Thread.MAX_PRIORITY); // 10
		t3.setPriority(Thread.MIN_PRIORITY); // 1

		// Display set priorities
		System.out.println("Set Priorities:");
		System.out.println(t1.getName() + " priority: " + t1.getPriority());
		System.out.println(t2.getName() + " priority: " + t2.getPriority());
		System.out.println(t3.getName() + " priority: " + t3.getPriority());

		// Start all threads
		t1.start();
		t2.start();
		t3.start();

		// Default priority for any new thread (inherited from parent)
		Thread defaultThread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " has default priority: "
					+ Thread.currentThread().getPriority());
		}, "DefaultThread");

		System.out.println("\nCreating a new thread without setting priority...");
		System.out.println("DefaultThread priority (before start): " + defaultThread.getPriority());
		defaultThread.start();
	}
}
