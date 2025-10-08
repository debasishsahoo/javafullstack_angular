package BankingSystem;

public class BankingSystem {

	public static void main(String[] args) {
		BankAccount savings = new SavingsAccount("SA001", "John Doe", 5000);
		savings.displayBankName();
		savings.displayAccountInfo();
		savings.deposit(1000);
		savings.withdraw(500);
		savings.calculateInterest();
		System.out.println("Final Balance: $" + savings.getBalance());

		System.out.println("\n-------------------\n");

		BankAccount current = new CurrentAccount("CA001", "Jane Smith", 2000);
		current.displayAccountInfo();
		current.withdraw(2500); // Using overdraft
		current.calculateInterest();
		System.out.println("Final Balance: $" + current.getBalance());

	}

}
