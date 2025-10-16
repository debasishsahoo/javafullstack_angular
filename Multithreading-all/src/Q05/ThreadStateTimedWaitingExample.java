package Q05;

public class ThreadStateTimedWaitingExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is entering TIMED_WAITING");
                Thread.sleep(5000); // waits for 5 seconds
                System.out.println(Thread.currentThread().getName() + " finished sleeping");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-1");

        t.start();

        // Give the thread time to enter TIMED_WAITING
        Thread.sleep(100);
        System.out.println(t.getName() + " state: " + t.getState()); // TIMED_WAITING

        // Wait until thread finishes
        t.join();
        System.out.println(t.getName() + " state after completion: " + t.getState()); // TERMINATED
    }
}

