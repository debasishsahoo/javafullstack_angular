package Q4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Approach 1: Extending Thread (Higher memory overhead)
class DownloadThread extends Thread {
	private String url;

	public DownloadThread(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " downloading from " + url);
	}
}

//Approach 2: Implementing Runnable (Lightweight and flexible)
class DownloadTask implements Runnable {
	private String url;

	public DownloadTask(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " downloading from " + url);
	}
}

public class MemoryOverheadComparison {

	public static void main(String[] args) {
		// Using Thread subclass (each object carries Thread overhead)
		System.out.println("=== Extending Thread Example ===");
		DownloadThread dt1 = new DownloadThread("http://example.com/file1");
		DownloadThread dt2 = new DownloadThread("http://example.com/file2");
		dt1.start();
		dt2.start();

		// Using Runnable (lightweight task objects)
		System.out.println("\n=== Implementing Runnable Example ===");
		DownloadTask task1 = new DownloadTask("http://example.com/file3");
		DownloadTask task2 = new DownloadTask("http://example.com/file4");

		// Option 1: Create Threads manually
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();

		// Option 2: Using Thread Pool (recommended and memory-efficient)
		System.out.println("\n=== Using ExecutorService (Thread Pool) ===");
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new DownloadTask("http://example.com/file5"));
		executor.submit(new DownloadTask("http://example.com/file6"));
		executor.submit(new DownloadTask("http://example.com/file7"));
		executor.shutdown();

	}

}
