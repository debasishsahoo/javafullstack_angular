package Q10;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private static final Object lock = new Object();

    private ThreadSafeSingleton() {
        // Private constructor
    }

    // Double-checked locking
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Alternative: synchronized method (simpler but less efficient)
    public static synchronized ThreadSafeSingleton getInstanceSimple() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    // Best approach: use static initialization
    private static class Holder {
        private static final ThreadSafeSingleton INSTANCE =
            new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstanceBest() {
        return Holder.INSTANCE;
    }
}
