package Q6;

public class Fix1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Task executed by: " + Thread.currentThread().getName()));
        t.start(); //  CORRECT - new thread created
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}

