package Q03;

public class MyRunnable implements Runnable {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Runnable: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();

	}

}
