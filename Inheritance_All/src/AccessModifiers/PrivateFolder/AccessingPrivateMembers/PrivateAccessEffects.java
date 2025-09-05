package AccessModifiers.PrivateFolder.AccessingPrivateMembers;

class BankAccount {
	private double balance; // Private field

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	// Public methods to interact with private field
	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	public double getBalance() {
		return balance;
	}

}

class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(double initialBalance, double interestRate) {
		super(initialBalance);
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		// Cannot directly access balance (it's private in parent)
		double currentBalance = getBalance(); // Use public accessor
		deposit(currentBalance * interestRate / 100);
	}

	// This method would not compile:
	public void manipulateBalance() {
		balance = 1000000; // ❌ Direct access to private field
	}

}

public class PrivateAccessEffects {

	public static void main(String[] args) {

	}

}

//## **The private access modifier:**
//
//- Prevents direct access to class members from subclasses
//- Ensures encapsulation and data hiding
//- Cannot be overridden in subclasses
//- Can be indirectly accessed through public/protected methods
//- When used on constructors, prevents class inheritance







