package priority;
//Two threads (HighPriorityThread and LowPriorityThread) continuously increment counters.
//Both run for 1 second, after which they are interrupted and joined.
//The ratio of increments shows how much CPU time each thread received.
//On systems where priority matters, the high-priority thread usually increments faster.



public class ThreadPriorityEffect {
	// Shared counters for both threads
	private static int highPriorityCounter = 0;
	private static int lowPriorityCounter = 0;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Thread Priority Impact Example ===");

		// High Priority Thread
		Thread highPriorityThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				highPriorityCounter++;
			}
		}, "HighPriorityThread");

		// Low Priority Thread
		Thread lowPriorityThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lowPriorityCounter++;
			}
		}, "LowPriorityThread");

		// Set priorities
		highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10
		lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // 1

		// Display priorities before start
		System.out.println("HighPriorityThread priority: " + highPriorityThread.getPriority());
		System.out.println("LowPriorityThread priority: " + lowPriorityThread.getPriority());

		// Start both threads
		highPriorityThread.start();
		lowPriorityThread.start();

		// Let both run for 1 second
		Thread.sleep(1000);

		// Stop threads by interrupting them
		highPriorityThread.interrupt();
		lowPriorityThread.interrupt();

		// Wait for both to finish
		highPriorityThread.join();
		lowPriorityThread.join();
		
		
		 // Display final results
        System.out.println("\n=== Results ===");
        System.out.println("High priority thread count: " + highPriorityCounter);
        System.out.println("Low priority thread count: " + lowPriorityCounter);
        
        double ratio = (lowPriorityCounter == 0)
                ? Double.POSITIVE_INFINITY
                : (double) highPriorityCounter / lowPriorityCounter;
        
        System.out.printf("Ratio (High/Low): %.3f%n", ratio);
        
        System.out.println("\n=== Notes ===");
        System.out.println("- Thread priorities are hints to the scheduler, not strict rules.");
        System.out.println("- Actual behavior depends on OS, JVM, and CPU cores.");
        System.out.println("- On some systems, results may appear nearly equal (multicore CPUs).");
        System.out.println("Windows  → More preference for high-priority thread");
        System.out.println("Linux/Unix → Usually interleaved equally (less effect)");
        System.out.println("macOS   → Minimal or no priority effect\n");
        
        
        
        
        
        
        

	}

}
