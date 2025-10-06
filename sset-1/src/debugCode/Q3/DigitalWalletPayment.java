package debugCode.Q3;

public class DigitalWalletPayment implements PaymentMethod, Authenticable, FeeCalculable {
	private String walletId;
	private String authToken;
	private static final double WALLET_FEE_PERCENT = 0.01; // 1% fee

	public DigitalWalletPayment(String walletId) {
		this.walletId = walletId;
	}

	@Override
	public boolean processPayment(double amount) {
		if (!authenticate(authToken))
			return false;
		double totalAmount = getTotalAmount(amount);
		System.out.println("Processing digital wallet payment: $" + totalAmount);
		return true;
	}
	
	@Override
    public double calculateTransactionFee(double amount) {
        return amount * WALLET_FEE_PERCENT;
    }

    @Override
    public double getTotalAmount(double amount) {
        return amount + calculateTransactionFee(amount);
    }
	
	
	
	
	@Override
	public boolean validate() {
		return walletId != null && !walletId.isEmpty();
	}

	@Override
	public String getPaymentDetails() {
		return "Digital Wallet: " + walletId;
	}

	@Override
	public String getPaymentType() {
		return "Digital Wallet";
	}
	
	
	@Override
    public boolean authenticate(String credential) {
        return this.authToken != null && this.authToken.equals(credential);
    }

    @Override
    public void setAuthToken(String token) {
        this.authToken = token;
    }

    
	
	
	
	
	
	
	
	
	
	
	
	
	

}
