package Q10;

//Demonstration of Synchronized Blocks in Java
public class SynchronizedBlockDemo {

 // Thread-safe counter using synchronized block
 static class Counter {
     private int count = 0;
     private final Object lock = new Object(); // Custom lock object

     public void increment() {
         // Only this section is synchronized, not the whole method
         synchronized (lock) {
             count++;
         }
     }

     public int getCount() {
         return count;
     }
 }

 // Non-synchronized version to show race condition
 static class UnsafeCounter {
     private int count = 0;

     public void increment() {
         count++; // No synchronization, not thread-safe
     }

     public int getCount() {
         return count;
     }
 }

 public static void main(String[] args) throws InterruptedException {

     // ---------- 1. Thread-safe version ----------
     Counter safeCounter = new Counter();

     Thread t1 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
             safeCounter.increment();
         }
     });

     Thread t2 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
             safeCounter.increment();
         }
     });

     long start = System.currentTimeMillis();
     t1.start();
     t2.start();
     t1.join();
     t2.join();
     long end = System.currentTimeMillis();

     System.out.println("Safe Counter (with synchronized block): " + safeCounter.getCount());
     System.out.println("Time taken: " + (end - start) + " ms");

     // ---------- 2. Non-thread-safe version ----------
     UnsafeCounter unsafeCounter = new UnsafeCounter();

     Thread t3 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
             unsafeCounter.increment();
         }
     });

     Thread t4 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
             unsafeCounter.increment();
         }
     });

     t3.start();
     t4.start();
     t3.join();
     t4.join();

     System.out.println("Unsafe Counter (no synchronization): " + unsafeCounter.getCount());
 }
 
 
// | Concept                  | Description                                                                               |
// | ------------------------ | ----------------------------------------------------------------------------------------- |
// | Lock object           | Used to synchronize specific sections of code instead of the whole method.                |
// | Fine-grained locking  | Only the critical section (`count++`) is locked — improving performance.                  |
// | Thread-safety         | Prevents multiple threads from updating `count` simultaneously.                           |
// | Race condition        | The `UnsafeCounter` version demonstrates how missing synchronization causes lost updates. |

 
 
 
 
 
 
 
 
 
}

