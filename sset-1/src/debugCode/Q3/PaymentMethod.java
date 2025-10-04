package debugCode.Q3;

// Base payment interface
public interface PaymentMethod {
	 boolean processPayment(double amount);
	 boolean validate();
	 String getPaymentDetails();
	 String getPaymentType();
}
