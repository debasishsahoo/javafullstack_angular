package StartVsRun;

//No new thread is created - Executes in the current thread
//Behaves like a normal method call - Just regular sequential execution
//Blocks the calling thread until run() completes
//Defeats the purpose of multithreading
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