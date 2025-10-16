package Q07;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadMethodsUseCases {

	// Shared buffer for wait() demonstration
	static class Buffer {
		private Queue<Integer> queue = new LinkedList<>();
		private int capacity = 5;

		// Producer adds items
		public synchronized void produce(int item) throws InterruptedException {
			while (queue.size() == capacity) {
				System.out.println("Producer waiting, buffer full...");
				wait(); // Wait for space
			}
			queue.add(item);
			System.out.println("Produced: " + item);
			notifyAll(); // Notify consumers
		}

		// Consumer removes items
		public synchronized int consume() throws InterruptedException {
			while (queue.isEmpty()) {
				System.out.println("Consumer waiting, buffer empty...");
				wait(); // Wait for items
			}
			int item = queue.remove();
			System.out.println("Consumed: " + item);
			notifyAll(); // Notify producers
			return item;
		}
	}

	// Example 1: sleep() – polling or animation updates
	static void sleepExample() {
		System.out.println("\n=== sleep() Example: Polling Simulation ===");
		boolean taskCompleted = false;
		int checkCount = 0;

		while (!taskCompleted && checkCount < 3) {
			System.out.println("Checking status... attempt " + (checkCount + 1));
			try {
				Thread.sleep(1000); // Pause 1 sec between checks
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			checkCount++;
		}
		taskCompleted = true;
		System.out.println("Task completed after checks!");
	}

	// Example 2: wait() – Producer-Consumer pattern
	static void waitExample() {
		System.out.println("\n=== wait() Example: Producer-Consumer ===");
		Buffer buffer = new Buffer();

		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++) {
					buffer.produce(i);
					Thread.sleep(500); // Simulate delay in producing
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++) {
					buffer.consume();
					Thread.sleep(1000); // Simulate delay in consuming
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Example 3: join() – Sequential task execution
	static void joinExample() {
		System.out.println("\n=== join() Example: Sequential Tasks ===");

		Thread download = new Thread(() -> {
			System.out.println("Downloading file...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Download completed");
		});

		Thread process = new Thread(() -> {
			System.out.println("Processing file...");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Processing completed");
		});

		download.start();
		try {
			download.join(); // Wait until download completes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		process.start();
		try {
			process.join(); // Wait until processing completes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Displaying result...");
	}

	public static void main(String[] args) {
		sleepExample();
		waitExample();
		joinExample();
	}
}
