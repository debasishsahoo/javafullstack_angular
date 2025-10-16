package Q06;

public class Fix2 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task executed by: " + Thread.currentThread().getName());

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); //  valid
        t2.start(); //  valid - different Thread object
    }
}

