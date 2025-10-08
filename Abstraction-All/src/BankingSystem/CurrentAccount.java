package BankingSystem;

public class CurrentAccount extends BankAccount{
	private double overdraftLimit = 1000.0;
    private static final double MIN_BALANCE = 0.0;
    
    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }
    
    @Override
    void calculateInterest() {
        // No interest for current accounts
        System.out.println("No interest for current accounts");
    }
    
    @Override
    boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            if (balance < 0) {
                System.out.println("Using overdraft facility");
            }
            return true;
        } else {
            System.out.println("Overdraft limit exceeded");
            return false;
        }
    }
    
    @Override
    double getMinimumBalance() {
        return MIN_BALANCE;
    }
}
