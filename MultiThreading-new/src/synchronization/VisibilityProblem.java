package synchronization;

public class VisibilityProblem {
	private boolean flag = false; // NOT volatile — visibility issue!

	public void writer() {
		System.out.println("Writer: Setting flag to true");
		flag = true; // Thread 1 sets flag
	}

	public void reader() {
		System.out.println("Reader: Waiting for flag...");
		while (!flag) { // Thread 2 might never see the change!
			// Busy wait — no synchronization or volatile
		}
		System.out.println("Reader: Flag is true!");
	}

	public static void main(String[] args) throws InterruptedException {
		VisibilityProblem problem = new VisibilityProblem();

		// Thread 1 — Writer thread
		Thread writerThread = new Thread(() -> {
			try {
				Thread.sleep(1000); // delay to ensure reader starts first
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			problem.writer();
		});

		// Thread 2 — Reader thread
		Thread readerThread = new Thread(problem::reader);

		readerThread.start();
		writerThread.start();

		// Wait for both threads to complete
		writerThread.join();
		readerThread.join();

		System.out.println("Main: Program finished.");
	}
}
