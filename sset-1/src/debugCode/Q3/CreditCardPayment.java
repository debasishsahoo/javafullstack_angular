package debugCode.Q3;

public class CreditCardPayment implements PaymentMethod, Authenticable, Refundable {
	private String cardNumber;
	private String expiryDate;
	private String cvv;
	private String authToken;

	public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	@Override
	public boolean processPayment(double amount) {
		if (!validate())
			return false;
		System.out.println("Processing credit card payment: $" + amount);
		// Actual payment processing logic would go here
		return true;
	}

	@Override
	public boolean validate() {
		return cardNumber != null && !cardNumber.isEmpty() && expiryDate != null && !expiryDate.isEmpty() && cvv != null
				&& cvv.length() == 3;
	}
	
	 @Override
	    public String getPaymentDetails() {
	        return "Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4);
	    }
	 @Override
	    public String getPaymentType() {
	        return "Credit Card";
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
