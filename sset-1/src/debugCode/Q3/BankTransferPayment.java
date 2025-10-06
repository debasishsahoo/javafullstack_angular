package debugCode.Q3;

public class BankTransferPayment implements PaymentMethod, Refundable, FeeCalculable{
	    private String accountNumber;
	    private String routingNumber;
	    private static final double BANK_FEE = 2.50; // Fixed bank fee
}
