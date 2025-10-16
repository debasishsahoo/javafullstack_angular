package Q08;

public class PriorityReliability {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Wrong Approach: Relying on Priority ===");

        // Thread 1 (High Priority)
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("High Priority Task: Step " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "HighPriorityThread");

        // Thread 2 (Low Priority)
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Low Priority Task: Step " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "LowPriorityThread");

        // Set priorities
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Start both threads — may run in any order depending on system
        thread1.start();
        thread2.start();

        // Wait for both to complete
        thread1.join();
        thread2.join();

        System.out.println("\n=== Correct Approach: Using Synchronization ===");

        // Proper synchronization ensures order
        Thread t1 = new Thread(() -> {
            System.out.println("Task 1: Executing");
        }, "Task1");

        Thread t2 = new Thread(() -> {
            System.out.println("Task 2: Executing (after Task 1)");
        }, "Task2");

        // Start t1 and wait for it to finish before starting t2
        t1.start();
        t1.join();
        t2.start();

        t2.join();
        System.out.println("\n=== Execution Completed ===");
    }
}
