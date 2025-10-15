package Q4;

class MyThread extends Thread {
	// The run() method contains the code to be executed in a new thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread by extending Thread class: " + i);
            try {
                Thread.sleep(500);  // pause for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}

public class ExtendThreadExample1 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread(); // create thread object
		t1.start(); // starts the thread (calls run() internally)

		// main thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("Main Thread: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

}
