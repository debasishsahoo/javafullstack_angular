package Q06;

public class RunVsStartExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println("Count: " + i);
            }
        });

        System.out.println("Before run()");

        // Directly calling run() - executes in main thread
        t.run();

        System.out.println("After run()");
    }
}

