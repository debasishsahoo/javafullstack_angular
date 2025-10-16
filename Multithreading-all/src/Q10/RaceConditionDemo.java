package Q10;

public class RaceConditionDemo {
    // Shared variable accessed by multiple threads
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        // Thread 1 increments counter 100,000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter++; // Not atomic!
            }
        }, "Thread-1");

        // Thread 2 increments counter 100,000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter++; // Not atomic!
            }
        }, "Thread-2");

        // Start threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        t1.join();
        t2.join();

        System.out.println("Expected: 200000");
        System.out.println("Actual: " + counter); // Often less than 200000 due to race condition
    }
}
