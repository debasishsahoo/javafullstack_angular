package Q09;

public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("=== Daemon Thread Example ===");

        // Create a thread that runs indefinitely
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon working...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon interrupted");
                    break;
                }
            }
        }, "DaemonThread");

        // Mark it as a daemon thread (must be done before start)
        daemon.setDaemon(true);

        // Start the daemon thread
        daemon.start();

        // Main thread sleeps for 3 seconds then exits
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting. JVM will terminate daemon threads.");
    }
}
