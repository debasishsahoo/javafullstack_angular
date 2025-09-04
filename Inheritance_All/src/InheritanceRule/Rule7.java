package InheritanceRule;

class BankAccount {
	protected double balance;
	
	BankAccount(double balance) {
        this.balance = balance;
    }
	
	void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
	
}

class SavingsAccount extends BankAccount {
	SavingsAccount(double balance) {
        super(balance);
    }
	
	@Override
    void withdraw(double amount) {
		// Add $2 fee to withdrawals
		double totalAmount = amount + 2;
		
		if (totalAmount <= balance) {
            balance -= totalAmount;
            System.out.println("Withdrew: " + amount + " with $2 fee");
        } else {
            System.out.println("Insufficient funds including fee");
        }
	}
}





public class Rule7 {

}
