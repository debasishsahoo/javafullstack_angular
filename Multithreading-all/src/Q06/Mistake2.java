package Q06;

public class Mistake2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Task executed"));
        t.start();
        t.start(); //  WRONG - throws IllegalThreadStateException
    }
}
