package Q10;

public class PerformanceComparison1 {
    // Use 'volatile' to ensure visibility across threads
    private volatile int counter = 0;

    /**
     *  Less efficient approach:
     * Locks the entire method — even non-critical work.
     * Other threads must wait even when the code isn't touching shared data.
     */
    public synchronized void incrementMethod() {
        doSomeWork(); // Non-critical
        counter++;    // Critical section
        doMoreWork(); // Non-critical
    }

    /**
     * Optimized approach:
     * Synchronize only the critical section (where shared data is modified).
     * Greatly improves concurrency performance.
     */
    public void incrementBlock() {
        doSomeWork(); // Can run in parallel safely

        // Only lock the shared resource update
        synchronized (this) {
            counter++;
        }

        doMoreWork(); // Can run in parallel safely
    }

    /**
     * Simulates an expensive, non-critical operation.
     * Not synchronized — can run concurrently.
     */
    private void doSomeWork() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i); // Dummy CPU work
        }
    }

    /**
     * Simulates another time-consuming, non-critical operation.
     * Not synchronized — can run concurrently.
     */
    private void doMoreWork() {
        for (int i = 0; i < 1000; i++) {
            Math.pow(i, 2); // Dummy CPU work
        }
    }

    //  For testing both synchronization styles
    public static void main(String[] args) throws InterruptedException {
        PerformanceComparison1 pc = new PerformanceComparison1();

        Runnable methodTask = pc::incrementMethod;
        Runnable blockTask = pc::incrementBlock;

        // Run both tests with multiple threads
        runPerformanceTest("Method-Level Synchronization", methodTask);
        runPerformanceTest("Block-Level Synchronization", blockTask);
    }

    private static void runPerformanceTest(String label, Runnable task) throws InterruptedException {
        PerformanceComparison1 pc = new PerformanceComparison1();

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
        System.out.println(label + " took " + (end - start) + " ms");
    }
}
