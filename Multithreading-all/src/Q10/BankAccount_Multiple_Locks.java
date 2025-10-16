package Q10;

public class BankAccount_Multiple_Locks {
    private double balance = 1000;
    private String accountHolder = "John Doe";

    private final Object balanceLock = new Object();
    private final Object holderLock = new Object();

    // Update balance safely
    public void updateBalance(double amount) {
        synchronized (balanceLock) {
            double oldBalance = balance;
            balance += amount;
            System.out.println(Thread.currentThread().getName() +
                " updated balance: " + oldBalance + " -> " + balance);
        }
    }

    // Update account holder safely
    public void updateAccountHolder(String name) {
        synchronized (holderLock) {
            String oldHolder = accountHolder;
            accountHolder = name;
            System.out.println(Thread.currentThread().getName() +
                " updated holder: " + oldHolder + " -> " + accountHolder);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount_Multiple_Locks account = new BankAccount_Multiple_Locks();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.updateBalance(100);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "BalanceThread");

        Thread t2 = new Thread(() -> {
            String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
            for (String name : names) {
                account.updateAccountHolder(name);
                try { Thread.sleep(150); } catch (InterruptedException e) {}
            }
        }, "HolderThread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance and account holder updated safely.");
    }
}
