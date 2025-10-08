package BankingSystem;

public abstract class BankAccount {
	protected String accountNumber;
	protected String accountHolderName;
	protected double balance;

	// Constructor
	public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = initialBalance;
	}

	// Abstract methods - each account type will implement differently
	abstract void calculateInterest();

	abstract boolean withdraw(double amount);

	abstract double getMinimumBalance();
	

    // Concrete methods - common to all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

	public double getBalance() {
		return balance;
	}

	public void displayAccountInfo() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Holder: " + accountHolderName);
		System.out.println("Balance: $" + balance);
	}

	// Final method - cannot be overridden
	public final void displayBankName() {
		System.out.println("Bank: National Bank of Java");
	}

}
