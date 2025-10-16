package lifecycle;

public class ThreadLifecycleDemo {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();

		Thread thread = new Thread(() -> {
			System.out.println("Thread started");

			// TIMED_WAITING state
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// WAITING state
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Thread ending");
		});

		System.out.println("State after creation: " + thread.getState()); // NEW

		thread.start();
		Thread.sleep(100);
		System.out.println("State after start(): " + thread.getState()); // RUNNABLE

		Thread.sleep(1000);
		System.out.println("State during sleep(): " + thread.getState()); // TIMED_WAITING

		Thread.sleep(2000);
		System.out.println("State during wait(): " + thread.getState()); // WAITING

		// Notify the waiting thread
		synchronized (lock) {
			lock.notify();
		}

		thread.join(); // Wait for thread to complete
		System.out.println("State after completion: " + thread.getState()); // TERMINATED
	}
}
