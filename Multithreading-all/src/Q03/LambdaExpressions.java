package Q03;

public class LambdaExpressions {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Lambda thread: " + i);
			}
		});
		 t1.start();
	}

}
