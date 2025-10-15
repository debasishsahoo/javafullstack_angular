package Q8;

import java.util.concurrent.*;

//Custom task class that includes a priority
class PriorityTask implements Runnable, Comparable<PriorityTask> {
 private final int priority;
 private final Runnable task;

 public PriorityTask(int priority, Runnable task) {
     this.priority = priority;
     this.task = task;
 }

 public int getPriority() {
     return priority;
 }

 @Override
 public void run() {
     task.run();
 }

 // Higher priority first
 @Override
 public int compareTo(PriorityTask other) {
     return Integer.compare(other.priority, this.priority);
 }
}

public class PriorityThreadPoolExample {
 public static void main(String[] args) {
     // Priority queue for tasks
     PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();

     // Thread pool using the priority queue
     ThreadPoolExecutor executor = new ThreadPoolExecutor(
             2, // core threads
             4, // max threads
             0L, TimeUnit.MILLISECONDS,
             queue
     );

     // Submit tasks with different priorities
     executor.execute(new PriorityTask(10, () -> criticalTask()));
     executor.execute(new PriorityTask(5, () -> normalTask()));
     executor.execute(new PriorityTask(1, () -> backgroundTask()));

     // Shutdown after tasks finish
     executor.shutdown();
 }

 private static void criticalTask() {
     System.out.println("Critical Task (Priority 10): Executing...");
     sleep(1000);
     System.out.println("Critical Task: Done");
 }

 private static void normalTask() {
     System.out.println("Normal Task (Priority 5): Executing...");
     sleep(1000);
     System.out.println("Normal Task: Done");
 }

 private static void backgroundTask() {
     System.out.println("Background Task (Priority 1): Executing...");
     sleep(1000);
     System.out.println("Background Task: Done");
 }

 private static void sleep(long ms) {
     try {
         Thread.sleep(ms);
     } catch (InterruptedException ignored) {}
 }
}
