package Q08;

public class PriorityHintExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Priority as a Hint Only ===");

        // High-priority thread: simulating an active user task
        Thread userTask = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("User Task: Working on step " + i);
                try {
                    Thread.sleep(300); // Simulate user activity
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UserTask");

        // Low-priority background thread: simulating background work
        Thread backgroundIndexer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Background Indexer: Indexing file " + i);
                try {
                    Thread.sleep(300); // Simulate background task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BackgroundIndexer");

        // Assign priorities (Hint to the scheduler)
        userTask.setPriority(Thread.NORM_PRIORITY + 2); // Slightly higher
        backgroundIndexer.setPriority(Thread.MIN_PRIORITY); // Run when idle

        // Start both
        userTask.start();
        backgroundIndexer.start();

        // Wait for both to finish
        userTask.join();
        backgroundIndexer.join();

        System.out.println("\n=== Execution Completed ===");
    }
}
