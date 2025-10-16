package Q08;
public class PriorityInversion {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Priority Inversion Example ===\n");

        // Low-priority thread holds the lock for a while
        Thread lowPriority = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Low: Acquired lock");
                try {
                    // Simulate long operation
                    Thread.sleep(5000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Low: Releasing lock");
            }
        }, "LowPriorityThread");
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        // High-priority thread that needs the same lock
        Thread highPriority = new Thread(() -> {
            try {
                Thread.sleep(100); // Ensure low priority acquires lock first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("High: Waiting for lock...");
            synchronized (lock) {
                System.out.println("High: Finally acquired lock!");
            }
        }, "HighPriorityThread");
        highPriority.setPriority(Thread.MAX_PRIORITY);

        // Medium-priority thread that can preempt the low one
        Thread mediumPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Medium: Running independent work " + (i + 1));
                try {
                    Thread.sleep(1000); // Keeps CPU busy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MediumPriorityThread");
        mediumPriority.setPriority(Thread.NORM_PRIORITY);

        // Start all threads
        lowPriority.start();
        highPriority.start();
        Thread.sleep(50);  // Let low start first
        mediumPriority.start();

        // Wait for all threads to complete
        lowPriority.join();
        mediumPriority.join();
        highPriority.join();

        System.out.println("\n=== All Threads Completed ===");
    }
}
