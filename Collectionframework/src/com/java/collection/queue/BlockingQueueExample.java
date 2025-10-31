package com.java.collection.queue;
//
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(() -> {
            try {
                queue.put("A");
                System.out.println("Produced A");
                queue.put("B");
                System.out.println("Produced B");
                queue.put("C"); // waits if queue is full
                System.out.println("Produced C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

