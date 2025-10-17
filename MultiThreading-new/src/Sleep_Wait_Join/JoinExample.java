package Sleep_Wait_Join;
//Makes the current thread wait until the thread on which join() is called completes its execution.

//What join() Does
//When one thread calls t.join(), it pauses until thread t finishes execution.
//The calling thread (in this case, the main thread) goes into a WAITING or TIMED_WAITING state.
//Once the target thread (t) terminates, the waiting thread resumes.


//Main thread starts T1 and T2.
//Main calls t1.join(), so it waits for T1 to finish.
//Meanwhile, T2 runs independently and completes early.
//4. After `T1` finishes, `Main` resumes and calls `t2.join()`.
//- Since `T2` has already completed, `join()` returns immediately.
//5. Finally, `Main` prints “All threads completed”.



//Instance method of Thread class
//Does NOT require synchronization
//Waits for thread death - until the target thread terminates
//Useful for thread coordination - ensuring tasks complete in order
//Thread state: RUNNABLE → WAITING (or TIMED_WAITING) → RUNNABLE

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		// Thread 1 - longer task
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": Starting task");
			try {
				Thread.sleep(7000); // Simulate work
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			System.out.println(Thread.currentThread().getName() + ": Task completed");
		}, "T1");

		// Thread 2 - shorter task
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": Starting task");
			try {
				Thread.sleep(3000); // Simulate work
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
