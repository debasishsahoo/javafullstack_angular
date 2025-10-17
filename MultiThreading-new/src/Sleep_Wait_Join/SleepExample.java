package Sleep_Wait_Join;
//Static method - called on Thread class, not thread instance
//Thread.sleep() is a static method, so you call it like Thread.sleep(2000) — not t.sleep(2000).
//Does NOT release locks - if thread holds a synchronized lock, it keeps it
//Wakes up automatically after the specified time
//Thread state: RUNNABLE → TIMED_WAITING → RUNNABLE
//It pauses the current thread (not all threads) for the given duration.

//Does Not Release Locks
//If a thread is inside a synchronized block and calls sleep(),
//it still holds the lock — preventing other threads from entering that block.
//SyncThread-1 acquires the lock and goes to sleep for 3 seconds.
//During this time, SyncThread-2 must wait — it is BLOCKED.





//public class SleepExample {
//	   public static void main(String[] args) {
//	        Thread t = new Thread(() -> {
//	            System.out.println("Thread started: " + System.currentTimeMillis());
//	            try {
//	                Thread.sleep(2000); // Pauses for 2 seconds
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	            System.out.println("Thread resumed: " + System.currentTimeMillis());
//	        });
//
//	        t.start();
//	    }
//}


public class SleepExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // Example 1: Simple sleep demonstration
        Thread t1 = new Thread(() -> {
            System.out.println("Thread started: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000); // Pauses for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            System.out.println("Thread resumed: " + System.currentTimeMillis());
        }, "SleepThread");

        
        
        // Example 2: Sleep inside synchronized block
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " entered synchronized block at: " + System.currentTimeMillis());
                try {
                    Thread.sleep(3000); // Holds the lock while sleeping!
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted");
                }
                System.out.println(Thread.currentThread().getName() + " exiting synchronized block at: " + System.currentTimeMillis());
            }
        }, "SyncThread-1");

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " got the lock at: " + System.currentTimeMillis());
            }
        }, "SyncThread-2");

        // Start threads
        t1.start();
        t2.start();

        // Delay to ensure t2 starts first
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
    }
}
