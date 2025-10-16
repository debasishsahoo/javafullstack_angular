package Q09;

public class DaemonDocumentationDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Documented Daemon Thread Demo ===");

        DaemonDocumentationDemo app = new DaemonDocumentationDemo();
        app.startMonitoring();

        // Main application simulates work
        for (int i = 1; i <= 3; i++) {
            System.out.println("Main application running... " + i);
            Thread.sleep(3000);
        }

        System.out.println("Main application exiting, daemon terminates automatically");
    }

    /**
     * Starts a background monitoring daemon that periodically
     * checks system health. This thread will terminate automatically
     * when the application exits and does not need explicit cleanup.
     */
    public void startMonitoring() {
        Thread monitor = new Thread(() -> {
            while (true) {
                checkSystemHealth();
                try {
                    Thread.sleep(5000); // Check every 5 seconds
                } catch (InterruptedException e) {
                    break; // Exit cleanly if interrupted
                }
            }
        });

        monitor.setDaemon(true);       // Mark as daemon
        monitor.setName("HealthMonitor"); // Give descriptive name
        monitor.start();
    }

    private void checkSystemHealth() {
        System.out.println(Thread.currentThread().getName() + ": System OK at " + new java.util.Date());
    }
}
