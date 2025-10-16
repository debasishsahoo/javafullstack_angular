package Q04;

//Example 2: Implementing Runnable (Shared Resource)
class MyTask implements Runnable {
	private int counter = 0; // Shared among all threads using same Runnable

	public void run() {
		for (int i = 1; i <= 5; i++) {
			counter++;
			System.out.println(Thread.currentThread().getName() + " - Shared Counter: " + counter);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class RunnableShareExample {

	public static void main(String[] args) {
		MyTask sharedTask = new MyTask(); // Single shared instance

		Thread t1 = new Thread(sharedTask, "Thread-A");
		Thread t2 = new Thread(sharedTask, "Thread-B");

		t1.start();
		t2.start();
	}

}
