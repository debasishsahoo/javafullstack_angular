package getter_and_setter;

public class BankAccount {
	private double balance;
	private String email;
	private double salary;
	private double width;
	private double height;

	// 1. Data Validation
	// Setters can validate data before storing it:

	public void setBalance(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative");
		}
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	// 2. Data Transformation
	// You can modify data during getting or setting:
	public void setEmail(String email) {
		this.email = email.toLowerCase().trim(); // Normalize email
	}

	public String getEmail() {
		return email;
	}

	
	
	// 3. Access Control
	//Control who can read or write data:
	public double getSalary() {
		return salary; // Anyone can read
	}

	private void setSalary(double salary) {
		this.salary = salary; // Only this class can modify
	}
	
	public static void main(String[] args) {
		BankAccount ba=new BankAccount();
		ba.setSalary(100);
	}
	
	//4. Computed Properties
	//Getters can calculate values on-demand:
	public double getArea() {
        return width * height; // Computed, not stored
    }
	

	

}
