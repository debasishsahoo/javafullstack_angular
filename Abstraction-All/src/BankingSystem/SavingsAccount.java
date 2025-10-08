package BankingSystem;

public class SavingsAccount extends BankAccount {
	private double interestRate = 0.04; // 4%
	private static final double MIN_BALANCE = 500.0;

	public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
		super(accountNumber, accountHolderName, initialBalance);
	}

	@Override
	void calculateInterest() {
		double interest = balance * interestRate;
		balance += interest;
		System.out.println("Interest added: $" + interest);
	}

	@Override
	boolean withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
			balance -= amount;
			System.out.println("Withdrawn: $" + amount);
			return true;
		} else {
			System.out.println("Insufficient balance or minimum balance constraint");
			return false;
		}
	}

	@Override
	double getMinimumBalance() {
		return MIN_BALANCE;
	}

}
