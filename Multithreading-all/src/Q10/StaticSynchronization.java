package Q10;

public class StaticSynchronization {
    private static int counter = 0;

    // Synchronized static method (locks on class object)
    public static synchronized void increment() {
        counter++;
    }

    // Equivalent using synchronized block on class
    public static void incrementExplicit() {
        synchronized (StaticSynchronization.class) {
            counter++;
        }
    }

    public static synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                StaticSynchronization.increment();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                StaticSynchronization.increment();
            }
        }, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter: " + StaticSynchronization.getCounter()); // Always 200000
    }
}
