package debugCode.Q3;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		List<PaymentMethod> payments = new ArrayList<>();

		CreditCardPayment creditCard = new CreditCardPayment("4111111111111111", "12/25", "123");
		creditCard.setAuthToken("cc_auth_token");

		DigitalWalletPayment wallet = new DigitalWalletPayment("wallet_12345");
		wallet.setAuthToken("wallet_auth_token");

		CryptocurrencyPayment crypto = new CryptocurrencyPayment("bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh");

		payments.add(creditCard);
		payments.add(wallet);
		payments.add(crypto);

		PaymentProcessor processor = new PaymentProcessor();
		processor.processPayments(payments, 100.0);

		// Demonstrate interface-specific functionality
		demonstrateInterfaceMethods(creditCard, wallet, crypto);

	}

	public static void demonstrateInterfaceMethods(PaymentMethod... payments) {
		System.out.println("\\n=== Interface-Specific Demonstrations ===");
		for (PaymentMethod payment : payments) {
			System.out.println("\\n" + payment.getPaymentType() + ":");

			if (payment instanceof Authenticable auth) {
				auth.setAuthToken("new_token");
				System.out.println("Authenticable interface supported");
			}

			if (payment instanceof FeeCalculable fee) {
				System.out.println("Fee: $" + fee.calculateTransactionFee(100));
			}

			if (payment instanceof Refundable refund) {
				System.out.println("Refundable: " + refund.getRefundPolicy());
			}
		}
	}
}
