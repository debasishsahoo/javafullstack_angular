package Q08;

public class InheritedPriority {

	public static void main(String[] args) {

		// Display main thread's default priority
		System.out.println("=== Inherited Priority Example ===");
		System.out.println("Main thread name: " + Thread.currentThread().getName());
		System.out.println("Main thread default priority: " + Thread.currentThread().getPriority());
		System.out.println();

		// Child thread 1 — created before changing main priority
		Thread child1 = new Thread(() -> {
			System.out.println("Child1 thread name: " + Thread.currentThread().getName());
			System.out.println("Child1 inherited priority: " + Thread.currentThread().getPriority());

			// Grandchild of main — inherits priority from child1
			Thread grandchild = new Thread(() -> {
				System.out.println("Grandchild thread name: " + Thread.currentThread().getName());
				System.out.println("Grandchild inherited priority: " + Thread.currentThread().getPriority());
			}, "GrandchildThread");

			grandchild.start();

			try {
				grandchild.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Child1Thread");

		child1.start();

		// Change main thread’s priority before creating another child
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

		System.out.println();
		System.out.println("Main thread priority changed to: " + Thread.currentThread().getPriority());
		System.out.println();

		// Child thread 2 — inherits the updated main thread priority
		Thread child2 = new Thread(() -> {
			System.out.println("Child2 thread name: " + Thread.currentThread().getName());
			System.out.println("Child2 inherited priority: " + Thread.currentThread().getPriority());
		}, "Child2Thread");

		child2.start();

		// Wait for all threads to complete
		try {
			child1.join();
			child2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n=== Execution Complete ===");
		System.out.println("Note: Thread priorities are inherited from the thread that creates them.");
	}
}
