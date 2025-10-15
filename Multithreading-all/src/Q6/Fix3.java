package Q6;

public class Fix3 {
    static void heavyTask() {
        System.out.println(Thread.currentThread().getName() + " executing heavyTask");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(Fix3::heavyTask);
            t.start(); //  CORRECT - runs concurrently
        }
    }
}

