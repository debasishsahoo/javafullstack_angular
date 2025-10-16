package Q10;

public class PerformanceComparison2 {
    private int counter = 0;

    //Less efficient - entire method is locked
    public synchronized void incrementMethod() {
        doSomeWork(); // Non-critical
        counter++;    // Critical
        doMoreWork(); // Non-critical
    }

    // More efficient - only critical section is locked
    public void incrementBlock() {
        doSomeWork(); // Runs without lock

        synchronized (this) {
            counter++; // Only this needs protection
        }

        doMoreWork(); // Runs without lock
    }

    private void doSomeWork() {
        // Simulate expensive operation (not thread-sensitive)
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }

    private void doMoreWork() {
        // Simulate another expensive operation (not thread-sensitive)
        for (int i = 0; i < 1000; i++) {
            Math.pow(i, 2);
        }
    }

    // Getter for counter (for verification)
    public int getCounter() {
        return counter;
    }

    // MAIN METHOD: Compare performance between both synchronization styles
    public static void main(String[] args) throws InterruptedException {
        PerformanceComparison2 pc1 = new PerformanceComparison2();
        PerformanceComparison2 pc2 = new PerformanceComparison2();

        // Runnable tasks
        Runnable methodTask = pc1::incrementMethod;
        Runnable blockTask = pc2::incrementBlock;

        System.out.println("Running performance comparison...");

        // Test method-level synchronization
        long methodTime = runTest(methodTask, "Method-Level Synchronization");

        // Test block-level synchronization
        long blockTime = runTest(blockTask, "Block-Level Synchronization");

        // Print final comparison
        System.out.println("\n=== Results ===");
        System.out.println("Method-Level Synchronization time: " + methodTime + " ms");
        System.out.println("Block-Level Synchronization time:  " + blockTime + " ms");

        if (blockTime < methodTime)
            System.out.println("Block-level synchronization is faster!");
        else
            System.out.println("Method-level synchronization took similar or less time (depends on CPU load).");
    }

    // Utility method to run each synchronization test
    private static long runTest(Runnable task, String label) throws InterruptedException {
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println(label + " completed in " + duration + " ms");
        return duration;
    }
}
