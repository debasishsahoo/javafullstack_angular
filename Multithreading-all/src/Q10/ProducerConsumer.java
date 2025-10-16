package Q10;

public class ProducerConsumer {
    private int data;
    private boolean available = false;
    private final Object lock = new Object();

    public void produce(int value) {
        synchronized(lock) {
            while (available) {
                try {
                    lock.wait(); // Wait for consumer
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            data = value;
            available = true;
            System.out.println("Produced: " + value);
            lock.notifyAll(); // Notify consumer
        }
    }

    public int consume() {
        synchronized(lock) {
            while (!available) {
                try {
                    lock.wait(); // Wait for producer
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            available = false;
            System.out.println("Consumed: " + data);
            lock.notifyAll(); // Notify producer
            return data;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                pc.produce(i);
                try {
                    Thread.sleep(500); // Simulate production delay
                } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                pc.consume();
                try {
                    Thread.sleep(800); // Simulate consumption delay
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
