package Q06;

public class StartVsRunDemo {
	public static void main(String[] args) {
		System.out.println("=== Using start() ===");
		Thread t1 = new Thread(() -> {
			System.out.println("t1 running in: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("t1 completed");
		});

		long startTime = System.currentTimeMillis();
		t1.start(); // Starts new thread
		System.out.println("Main thread continues immediately");

		try {
			t1.join(); // Wait for t1 to complete
		} catch (InterruptedException e) {
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms\n");

		System.out.println("=== Using run() ===");
		Thread t2 = new Thread(() -> {
			System.out.println("t2 running in: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("t2 completed");
		});

		startTime = System.currentTimeMillis();
		t2.run(); // Just calls run() method
		System.out.println("Main thread had to wait");

		endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
	}
}
