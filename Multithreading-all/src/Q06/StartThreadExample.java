package Q06;

public class StartThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": Thread is running");
        }, "MyThread");

        System.out.println(thread.getName() + " state before start(): " + thread.getState()); // NEW

        // Start the thread
        thread.start();

        System.out.println(thread.getName() + " state after start(): " + thread.getState()); // RUNNABLE or RUNNING

        try {
            // Wait for thread to complete
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName() + " state after completion: " + thread.getState()); // TERMINATED
    }
}

