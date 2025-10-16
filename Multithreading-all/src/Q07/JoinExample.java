package Q07;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		// Thread 1 - longer task
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": Starting task");
			try {
				Thread.sleep(2000); // Simulate work
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			System.out.println(Thread.currentThread().getName() + ": Task completed");
		}, "T1");

		// Thread 2 - shorter task
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": Starting task");
			try {
				Thread.sleep(1000); // Simulate work
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			System.out.println(Thread.currentThread().getName() + ": Task completed");
		}, "T2");

		System.out.println("Main: Starting threads");
		t1.start();
		t2.start();

		// Main thread waits for T1 to complete before proceeding
		System.out.println("Main: Waiting for T1 to complete");
		t1.join();

		// Then waits for T2 to complete
		System.out.println("Main: Waiting for T2 to complete");
		t2.join();

		System.out.println("Main: All threads completed");
	}
}
