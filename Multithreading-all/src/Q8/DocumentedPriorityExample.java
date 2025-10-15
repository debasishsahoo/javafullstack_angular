package Q8;

public class DocumentedPriorityExample {

    public static void main(String[] args) {

        // High-priority thread for user-critical operation
        Thread uiThread = new Thread(() -> {
            System.out.println("UI Thread: Handling user input...");
            handleUserInput();
        }, "UIThread");

        // Normal-priority thread for standard business logic
        Thread computationThread = new Thread(() -> {
            System.out.println("Computation Thread: Performing calculations...");
            performComputation();
        }, "ComputationThread");

        // Low-priority thread for background maintenance
        Thread backgroundThread = new Thread(() -> {
            System.out.println("Background Thread: Cleaning up temporary files...");
            performCleanup();
        }, "BackgroundThread");

        // Documented priorities
        // UIThread - MAX_PRIORITY: must respond quickly to user input
        uiThread.setPriority(Thread.MAX_PRIORITY);

        // ComputationThread - NORM_PRIORITY: performs core logic without starving UI
        computationThread.setPriority(Thread.NORM_PRIORITY);

        // BackgroundThread - MIN_PRIORITY: background maintenance, should not interrupt user operations
        backgroundThread.setPriority(Thread.MIN_PRIORITY);

        // Start all threads
        uiThread.start();
        computationThread.start();
        backgroundThread.start();
    }

    private static void handleUserInput() {
        simulateWork("User interaction", 3);
    }

    private static void performComputation() {
        simulateWork("Complex computation", 5);
    }

    private static void performCleanup() {
        simulateWork("Cleanup task", 7);
    }

    private static void simulateWork(String task, int steps) {
        for (int i = 1; i <= steps; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + task + " step " + i);
            try {
                Thread.sleep(300); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + task + " completed.");
    }
}