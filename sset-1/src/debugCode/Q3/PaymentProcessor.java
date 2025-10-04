package debugCode.Q3;

import java.util.List;

public class PaymentProcessor {

	public void processPayments(List<PaymentMethod> payments, double amount) {

		for (PaymentMethod payment : payments) {
			System.out.println("\\n=== Processing " + payment.getPaymentType() + " ===");
			System.out.println("Details: " + payment.getPaymentDetails());

			if (payment.validate()) {
				boolean success = payment.processPayment(amount);
				System.out.println("Payment " + (success ? "successful" : "failed"));

				// Demonstrate interface-specific behaviors
				if (payment instanceof FeeCalculable feePayment) {
					double fee = ((FeeCalculable) payment).calculateTransactionFee(amount);
					System.out.println("Transaction fee: $" + fee);
				}
				if (payment instanceof Refundable refundable) {
                    System.out.println("Refund policy: " + refundable.getRefundPolicy());
                }

			}else {
				 System.out.println("Payment validation failed");
			}

		}

	}

}
