package Q06;

public class Mistake1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Task executed by: " + Thread.currentThread().getName()));
        t.run(); //  WRONG - no new thread created
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}

