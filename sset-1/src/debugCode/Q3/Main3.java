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
        

	}

}
