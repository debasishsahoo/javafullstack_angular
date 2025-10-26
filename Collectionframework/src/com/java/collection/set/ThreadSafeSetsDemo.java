package com.java.collection.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeSetsDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== THREAD-SAFE SETS DEMONSTRATION ===\n");

		// 1. Collections.synchronizedSet()
		System.out.println("1. Collections.synchronizedSet():");
		Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());

		// Must synchronize during iteration
		syncSet.addAll(Arrays.asList(1, 2, 3, 4, 5));
		synchronized (syncSet) {
			Iterator<Integer> it = syncSet.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
		}
		System.out.println("\n");

		// 2. ConcurrentSkipListSet
		System.out.println("2. ConcurrentSkipListSet:");
		Set<Integer> concurrentSet = new ConcurrentSkipListSet<>();

		// Multiple threads adding elements
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CountDownLatch latch = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			final int threadNum = i;
			executor.submit(() -> {
				for (int j = 0; j < 100; j++) {
					concurrentSet.add(threadNum * 100 + j);
				}
				latch.countDown();
			});
		}

		latch.await();
		executor.shutdown();

		System.out.println("Elements added by 5 threads: " + concurrentSet.size());
		System.out.println("First 10 elements: ");
		concurrentSet.stream().limit(10).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");

		// 3. CopyOnWriteArraySet
		System.out.println("3. CopyOnWriteArraySet:");
		Set<String> cowSet = new CopyOnWriteArraySet<>();
		cowSet.add("Element1");
		cowSet.add("Element2");
		cowSet.add("Element3");

		// Safe iteration without synchronization
		Thread reader = new Thread(() -> {
			for (String element : cowSet) {
				System.out.println("Reading: " + element);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread writer = new Thread(() -> {
			try {
				Thread.sleep(50);
				cowSet.add("Element4");
				System.out.println("Added: Element4");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		reader.start();
		writer.start();
		reader.join();
		writer.join();

		System.out.println("Final set: " + cowSet);
		System.out.println();

		// 4. Performance comparison
		System.out.println("4. Performance Comparison:");
		testPerformance("HashSet (not thread-safe)", new HashSet<>());
		testPerformance("SynchronizedSet", Collections.synchronizedSet(new HashSet<>()));
		testPerformance("ConcurrentSkipListSet", new ConcurrentSkipListSet<>());
		testPerformance("CopyOnWriteArraySet", new CopyOnWriteArraySet<>());
	}

	private static void testPerformance(String name, Set<Integer> set) {
		long start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			set.add(i);
		}
		long duration = System.nanoTime() - start;
		System.out.println(name + ": " + duration / 1000000.0 + " ms");
	}
}
