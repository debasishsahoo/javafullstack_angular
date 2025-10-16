package ThreadVsRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Example 2: Implementing Runnable (Compatible with Executor)

class MyTask2 implements Runnable {
	private String taskName;

	public MyTask2(String taskName) {
		this.taskName = taskName; //identifies the task (like “Task-1”, “Task-2”).
	}

	//run() method defines the code that runs in a thread
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing task: " + taskName); //Print Details
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
		//The pool manages these threads and reuses them to execute multiple tasks.
		//Even if you submit 6 tasks, only 3 run at once, and others wait in a queue until a thread is free.

		// Submit multiple Runnable tasks
		for (int i = 1; i <= 6; i++) {
			//Submits 6 tasks (Task-1 to Task-6) to the executor.
			//Since the pool size = 3:(At any time, 3 tasks execute in parallel.)
			//When one thread finishes, it automatically takes the next task
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