package synchronization;

//Atomic variables are part of the java.util.concurrent.atomic package and 
//provide lock-free, thread-safe operations on single variables.

//Instead of using synchronized or ReentrantLock, 
//these classes use low-level atomic CPU instructions (like compare-and-swap, CAS) 
//to ensure that updates to a variable are performed atomically — 
//meaning the operation cannot be interrupted mid-way by another thread.

// use atomic variables (which are non-blocking and faster).
//Atomic variables are ideal for:

//- Counters (`AtomicInteger`, `AtomicLong`)
//- Flags (`AtomicBoolean`)
//- References (`AtomicReference<T>`)
//AtomicIntegerArray
//AtomicLongArray

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariable {
	private AtomicInteger counter = new AtomicInteger(0);

	public void increment() {
		// Thread-safe increment operation (atomic)
		counter.incrementAndGet();
	}

	public int getCounter() {
		return counter.get();
	}

	public static void main(String[] args) {
		AtomicVariable example = new AtomicVariable();

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				example.increment();
			}
		};

		// Create multiple threads
		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		Thread t3 = new Thread(task, "Thread-3");

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Counter Value: " + example.getCounter());
	}

}
