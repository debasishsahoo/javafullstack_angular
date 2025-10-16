package Q09;

public class DaemonStatusExample {
    public static void main(String[] args) {
        System.out.println("=== Daemon Status Check Example ===");

        // Create a new thread
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +
                    " is daemon? " + Thread.currentThread().isDaemon());
        }, "MyThread");

        // Check default daemon status
        System.out.println("Before setDaemon: " + thread.isDaemon()); // false

        // Set as daemon
        thread.setDaemon(true);

        // Check daemon status after setting
        System.out.println("After setDaemon: " + thread.isDaemon());  // true

        // Start the thread
        thread.start();
    }
}

