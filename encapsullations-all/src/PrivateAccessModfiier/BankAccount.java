package PrivateAccessModfiier;

//UseCase
//Sensitive data that should never be directly accessed
//Internal helper methods
//Implementation-specific details

//Benefit
//1.Data Hiding
//2.Controlled Access
//3.Improved Security
//4.Flexibility

public class BankAccount {
	 private double balance; // Only accessible within this class
	 private String accountNumber;
	 private void calculateInterest() {
		 // Private helper method - internal implementation detail
	 }
	
	 public void deposit() {
		
	 }
	 
	 public void withdraw() {}
	 
	 
	 
	 
}
