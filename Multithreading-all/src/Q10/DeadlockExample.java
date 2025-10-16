package Q10;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock1...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1: Waiting for lock2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock1 & lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock2...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 2: Waiting for lock1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock1 & lock2");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(() -> example.method1());
        Thread t2 = new Thread(() -> example.method2());

        t1.start();
        t2.start();

        System.out.println("Both threads started — Deadlock may occur!");
    }
}

