package Q06;

public class Mistake3 {
    static void heavyTask() {
        System.out.println(Thread.currentThread().getName() + " executing heavyTask");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(Mistake3::heavyTask);
            t.run(); //  WRONG - all tasks run sequentially in main thread
        }
    }
}
