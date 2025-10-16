package Thread;

class MyRunnable implements Runnable {
	public void run() {
		System.out.println("Thread running...");
	}
}

public class ThreadExample3 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
	}

}
