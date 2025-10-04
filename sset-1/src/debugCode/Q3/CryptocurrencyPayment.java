package debugCode.Q3;

public class CryptocurrencyPayment implements PaymentMethod, FeeCalculable {
	private String walletAddress;
	private double networkFee; // Can vary based on network congestion

	public CryptocurrencyPayment(String walletAddress) {
		this.walletAddress = walletAddress;
		this.networkFee = 0.0001; // Default fee
	}

	@Override
	public boolean processPayment(double amount) {
		if (!validate())return false;
		double totalAmount = getTotalAmount(amount);
		System.out.println("Processing cryptocurrency payment: " + totalAmount + " BTC");
		return true;
	}

	@Override
	public boolean validate() {
		return walletAddress != null && walletAddress.startsWith("bc1") && walletAddress.length() > 20;
	}
	
	@Override
    public String getPaymentDetails() {
        return "Crypto Wallet: " + walletAddress.substring(0, 8) + "...";
    }

    @Override
    public String getPaymentType() {
        return "Cryptocurrency";
    }

    @Override
    public double calculateTransactionFee(double amount) {
        // Crypto fees are often fixed rather than percentage-based
        return networkFee;
    }

    @Override
    public double getTotalAmount(double amount) {
        return amount + networkFee;
    }

    public void setNetworkFee(double fee) {
        this.networkFee = fee;
    }

}
