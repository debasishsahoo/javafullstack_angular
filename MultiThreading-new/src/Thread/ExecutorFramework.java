package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit(()->{System.out.println("Task 1 executing");});//Thread 0
		executor.submit(()->{System.out.println("Task 2 executing");});//Thread 1
		
		executor.shutdown();
		
		
		
	}
}
