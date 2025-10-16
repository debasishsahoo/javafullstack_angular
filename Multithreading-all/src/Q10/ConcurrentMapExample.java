package Q10;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void put(String key, int value) {
        map.put(key, value); // Thread-safe
    }

    public Integer get(String key) {
        return map.get(key);
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentMapExample example = new ConcurrentMapExample();

        // Runnable task to put values
        Runnable putTask = () -> {
            for (int i = 0; i < 1000; i++) {
                example.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        // Runnable task to read values
        Runnable getTask = () -> {
            for (int i = 0; i < 1000; i++) {
                example.get(Thread.currentThread().getName() + "-" + i);
            }
        };

        // Create multiple threads
        Thread t1 = new Thread(putTask, "Writer-1");
        Thread t2 = new Thread(putTask, "Writer-2");
        Thread t3 = new Thread(getTask, "Reader-1");
        Thread t4 = new Thread(getTask, "Reader-2");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Map size after concurrent operations: " + example.map.size());
    }
}
