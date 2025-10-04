package debugCode.Q3;

// Interface for payment methods with transaction fees
public interface FeeCalculable {
	  double calculateTransactionFee(double amount);
	  double getTotalAmount(double amount);
}
