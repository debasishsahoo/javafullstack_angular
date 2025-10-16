package Q03;

public class MyThread extends Thread {
	@Override
	public void run() {
		// Code to be executed by the thread
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread: " + i);
			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start(); // Start the thread

	}

}
