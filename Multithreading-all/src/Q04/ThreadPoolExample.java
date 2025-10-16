package Q04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Example 2: Implementing Runnable (Compatible with Executor)

class MyTask2 implements Runnable {
	private String taskName;

	public MyTask2(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing task: " + taskName);
		try {
			Thread.sleep(500); // simulate work
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}

public class ThreadPoolExample {

	public static void main(String[] args) {
		// Create a thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Submit multiple Runnable tasks
		for (int i = 1; i <= 6; i++) {
			executor.submit(new MyTask2("Task-" + i));
		}

		// Shutdown the executor
		executor.shutdown();

		try {
			// Wait for all tasks to finish
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("All tasks completed.");
	}

}
