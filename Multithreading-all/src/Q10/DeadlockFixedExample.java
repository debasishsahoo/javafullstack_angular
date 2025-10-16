package Q10;

public class DeadlockFixedExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1Fixed() {
        synchronized(lock1) {
            System.out.println("Thread 1: Acquired lock1");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized(lock2) {
                System.out.println("Thread 1: Acquired lock2, doing work");
            }
        }
    }

    public void method2Fixed() {
        synchronized(lock1) { // Acquire in same order!
            System.out.println("Thread 2: Acquired lock1");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized(lock2) {
                System.out.println("Thread 2: Acquired lock2, doing work");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockFixedExample example = new DeadlockFixedExample();

        new Thread(() -> example.method1Fixed()).start();
        new Thread(() -> example.method2Fixed()).start();
    }
}
