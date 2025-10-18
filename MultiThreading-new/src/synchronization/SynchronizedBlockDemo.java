package synchronization;

public class SynchronizedBlockDemo {
	// Thread-safe counter using synchronized block
	static class Counter {
		private int count = 0;
		private final Object lock = new Object(); // Custom lock object

		public void increment() {
			// Only this section is synchronized, not the whole method
			synchronized (lock) {
				count++;
			}
		}

		public int getCount() {
			return count;
		}
	}

	// Non-synchronized version to show race condition
	static class UnsafeCounter {
		private int count = 0;

		public void increment() {
			count++; // No synchronization, not thread-safe
		}

		public int getCount() {
			return count;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// ---------- 1. Thread-safe version ----------
		Counter safeCounter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				safeCounter.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				safeCounter.increment();
			}
		});

//		long start1 = System.currentTimeMillis();
//		t1.start();
//		t2.start();
//		t1.join();
//		t2.join();
//		long end1 = System.currentTimeMillis();
//
//		System.out.println("Safe Counter (with synchronized block): " + safeCounter.getCount());
//		System.out.println("Time taken: " + (end1 - start1) + " ms");
		
		// ---------- 2. Non-thread-safe version ----------
	     UnsafeCounter unsafeCounter = new UnsafeCounter();

	     Thread t3 = new Thread(() -> {
	         for (int i = 0; i < 100000; i++) {
	             unsafeCounter.increment();
	         }
	     });

	     Thread t4 = new Thread(() -> {
	         for (int i = 0; i < 100000; i++) {
	             unsafeCounter.increment();
	         }
	     });

	     long start2 = System.currentTimeMillis();
	     t3.start();
	     t4.start();
	     t3.join();
	     t4.join();
	     long end2 = System.currentTimeMillis();
	     System.out.println("Unsafe Counter (no synchronization): " + unsafeCounter.getCount());
	     System.out.println("Time taken: " + (end2 - start2) + " ms");
		
		
		
		
		
		
		
		
		

	}

}
