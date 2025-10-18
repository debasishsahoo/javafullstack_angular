package synchronization;

//Two threads waiting for each other's locks:

//How to Avoid Deadlocks
//1.Lock Ordering:Always acquire multiple locks in the same order in all threads.
//1.1 Synchronizing on Wrong Object:Always synchronize on a dedicated, final, mutable lock object (usually private final Object lock = new Object();).
//2.Try-Lock with Timeout (ReentrantLock):Use ReentrantLock.tryLock(timeout) to avoid waiting forever.
//3.Reduce Lock Scope:Hold locks only as long as necessary.
//4.Avoid Nested Locks:Avoid locking multiple objects at the same time when possible.


public class DeadlockExample {
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public void method1() {
		synchronized (lock1) {
			System.out.println("Thread 1: Holding lock1...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread 1: Waiting for lock2...");
			synchronized (lock2) {
				System.out.println("Thread 1: Holding lock1 & lock2");
			}
		}
	}

	public void method2() {
		synchronized (lock2) {
			System.out.println("Thread 2: Holding lock2...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread 2: Waiting for lock1...");
			synchronized (lock1) {
				System.out.println("Thread 2: Holding lock1 & lock2");
			}
		}
	}

	public static void main(String[] args) {
		DeadlockExample example = new DeadlockExample();

		Thread t1 = new Thread(() -> example.method1());
		Thread t2 = new Thread(() -> example.method2());

		t1.start();
		t2.start();

		System.out.println("Both threads started — Deadlock may occur!");

	}

}
