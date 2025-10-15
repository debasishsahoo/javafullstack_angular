package Q3;

public class Anonymous {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous thread running");
			}
		});
		t1.start();
	}

}
