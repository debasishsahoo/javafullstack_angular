package Q8;

public class PlatformDependency {

	public static void main(String[] args) {

		System.out.println("=== Platform Dependency Example ===");
		System.out.println("This example shows how thread priorities behave differently across OS platforms.\n");

		// High-priority thread
		Thread highPriorityThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("High Priority Thread: " + i);
				try {
					Thread.sleep(50); // Short sleep to interleave output
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "HighPriorityThread");

		// Low-priority thread
		Thread lowPriorityThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Low Priority Thread: " + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "LowPriorityThread");

		// Set different priorities
		highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10
		lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // 1

		// Display priorities
		System.out.println("HighPriorityThread priority: " + highPriorityThread.getPriority());
		System.out.println("LowPriorityThread priority: " + lowPriorityThread.getPriority());
		System.out.println("\nStarting both threads...\n");

		// Start both threads
		highPriorityThread.start();
		lowPriorityThread.start();

		// Wait for both threads to finish
		try {
			highPriorityThread.join();
			lowPriorityThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n=== Execution Complete ===");
		System.out.println("Observe the order of outputs to see how your OS handles priorities.\n");

		System.out.println("=== Expected Output Behavior by Platform ===");
		System.out.println("Windows  → More preference for high-priority thread");
		System.out.println("Linux/Unix → Usually interleaved equally (less effect)");
		System.out.println("macOS   → Minimal or no priority effect\n");
	}
}
