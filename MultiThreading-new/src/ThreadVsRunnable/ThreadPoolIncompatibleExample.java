package ThreadVsRunnable;

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
     ExecutorService executor = Executors.newFixedThreadPool(2);
     executor.submit(t1); // ERROR: Not a Runnable or Callable but seems to work — why?
     executor.submit(t2); 
     executor.shutdown();
     //ExecutorService.submit() only accepts Runnable or Callable objects.
     //Since Thread itself represents a running unit (not a simple task), it’s not reusable in thread pools.
     //The ExecutorService thread (like pool-1-thread-1) will call t1.run() inside itself,
     //not t1.start().
     
//     So what happens:
//
//    	 - `t1.start()` → creates a **new thread** (`Thread-0`)
//    	 - `t2.start()` → creates another thread (`Thread-1`)
//    	 - `executor.submit(t1)` → executes `t1.run()` again, but **inside the pool’s thread** (`pool-1-thread-1`)
     
     
     
     
     
     
     
     
     
     
 }
}
