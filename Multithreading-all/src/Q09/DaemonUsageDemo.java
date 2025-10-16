package Q09;

public class DaemonUsageDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Daemon Thread Usage Demo ===");

        // GOOD: Daemon for non-critical background task (monitoring)
        Thread monitor = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                logSystemStats();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "SystemMonitor");
        monitor.setDaemon(true); // Safe: non-critical
        monitor.start();

        // BAD: Daemon for critical task (database writes)
        Thread writer = new Thread(() -> {
            saveCriticalData();
        }, "DatabaseWriter");
        writer.setDaemon(true); // DON'T DO THIS!
        writer.start();

        // Main thread simulates work
        Thread.sleep(3000);
        System.out.println("Main thread exiting, daemon threads terminate");
    }

    private static void logSystemStats() {
        System.out.println(Thread.currentThread().getName() + ": Logging system stats...");
    }

    private static void saveCriticalData() {
        System.out.println(Thread.currentThread().getName() + ": Writing critical data...");
        try {
            Thread.sleep(5000); // Simulate long operation
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + ": Finished writing data");
    }
}
