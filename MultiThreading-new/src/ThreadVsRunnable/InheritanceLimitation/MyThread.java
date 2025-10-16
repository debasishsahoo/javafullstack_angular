package ThreadVsRunnable.InheritanceLimitation;
//Java doesn't support multiple inheritance
public class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

//class can still extend another class while implementing Runnable,
class MyTask extends ABC implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}