package InheritanceLimitations;

class BankAccount {
    private double balance; // Private field

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() { // Public getter
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    void showBalance() {
        System.out.println("Balance: " + balance); // ❌ ERROR: private field
        System.out.println("Balance: " + getBalance()); // ✅ OK: use public method
    }
}
























public class Rule4 {

}
