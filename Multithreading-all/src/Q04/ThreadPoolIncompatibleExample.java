package Q04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Example 1: Extending Thread (Not compatible with Executor)
class MyThread2 extends Thread {
 public void run() {
     System.out.println(Thread.currentThread().getName() + " executing MyThread task");
 }
}

public class ThreadPoolIncompatibleExample {
 public static void main(String[] args) {
     MyThread2 t1 = new MyThread2();
     MyThread2 t2 = new MyThread2();

     // These must be started manually
     t1.start();
     t2.start();

     // Can't submit 'MyThread2' directly to ExecutorService
     //ExecutorService executor = Executors.newFixedThreadPool(2);
     //executor.submit(t1); // ERROR: Not a Runnable or Callable but seems to work — why?
 }
}
