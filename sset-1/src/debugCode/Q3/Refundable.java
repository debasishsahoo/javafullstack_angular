package debugCode.Q3;

//Interface for refundable payments
public interface Refundable {
	boolean processRefund(double amount, String transactionId);
    String getRefundPolicy();
}
