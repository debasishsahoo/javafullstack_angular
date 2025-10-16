package Q10;

public class SynchronizedBlockExample {
    private int counter = 0;
    private final Object lock = new Object();
    private final Object customLock = new Object();

    // Increment with fine-grained synchronization
    public void increment() {
        // Non-critical code
        System.out.println(Thread.currentThread().getName() + ": Preparing...");

        // Critical section
        synchronized (lock) {
            counter++;
        }

        // Non-critical code
        System.out.println(Thread.currentThread().getName() + ": Done");
    }

    // Decrement using 'this' as lock
    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }

    // Reset using a custom lock
    public void reset() {
        synchronized (customLock) {
            counter = 0;
        }
    }

    public int getCounter() {
        synchronized (lock) { // Read counter safely
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlockExample obj = new SynchronizedBlockExample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                obj.increment();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                obj.increment();
            }
        }, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Counter: " + obj.getCounter()); // Always 200000
    }
}

