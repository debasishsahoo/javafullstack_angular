package Q8;

public class TaskManager {

	public static void main(String[] args) {
		System.out.println("=== Thread Priority Example ===\n");

		// Critical system task (Highest priority)
		Thread systemTask = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " started (Priority: "
					+ Thread.currentThread().getPriority() + ")");
			performBackup();
			System.out.println(Thread.currentThread().getName() + " completed.");
		}, "SystemTask");
		systemTask.setPriority(Thread.MAX_PRIORITY);

		// Normal user task (Normal priority)
		Thread userTask = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " started (Priority: "
					+ Thread.currentThread().getPriority() + ")");
			processDocument();
			System.out.println(Thread.currentThread().getName() + " completed.");
		}, "UserTask");
		userTask.setPriority(Thread.NORM_PRIORITY);

		// Background task (Lowest priority)
		Thread backgroundTask = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " started (Priority: "
					+ Thread.currentThread().getPriority() + ")");
			indexFiles();
			System.out.println(Thread.currentThread().getName() + " completed.");
		}, "BackgroundTask");
		backgroundTask.setPriority(Thread.MIN_PRIORITY);

		// Start all threads
		systemTask.start();
		userTask.start();
		backgroundTask.start();

		// Wait for all threads to finish
		try {
			systemTask.join();
			userTask.join();
			backgroundTask.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n=== All tasks completed ===");
	}

	// Simulate a critical system operation
	private static void performBackup() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("SystemTask: Backing up file " + i);
			try {
				Thread.sleep(300); // Simulate time delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Simulate user-level document processing
	private static void processDocument() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("UserTask: Processing page " + i);
			try {
				Thread.sleep(400); // Simulate processing delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Simulate background indexing operation
	private static void indexFiles() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("BackgroundTask: Indexing file " + i);
			try {
				Thread.sleep(500); // Simulate slower background task
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
