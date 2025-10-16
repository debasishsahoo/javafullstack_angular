package ThreadVsRunnable;

//Example 1: Extending Thread (No Shared Resource)
//Each thread object is unique and cannot be reused once it completes.
class MyThread1 extends Thread {
	private int counter = 0; // Each thread has its own counter

	public void run() {
		for (int i = 1; i <= 5; i++) {
			counter++;
			System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class ThreadNoShareExample {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread1 t2 = new MyThread1();
		MyThread1 t3 = new MyThread1();

		t1.setName("Thread-A");
		t2.setName("Thread-B");
		t3.setName("Thread-C");

		t1.start();
		t2.start();
		t3.start();
	}

}