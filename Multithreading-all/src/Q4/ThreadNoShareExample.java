package Q4;

//Example 1: Extending Thread (No Shared Resource)
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

        t1.setName("Thread-A");
        t2.setName("Thread-B");

        t1.start();
        t2.start();
	}

}
