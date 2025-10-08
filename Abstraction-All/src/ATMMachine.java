
public class ATMMachine {
	public void Enter_Card() {
		System.out.println("Card Verification");
	}

	public void Enter_Pin() {
		System.out.println("Pin Verification");
	}

	public void Cash_Withdrawal() {
		System.out.println("To withdraw cash from ATM");
		Validate_Withdraw_Amount();
		Update_Amount();
		Cash_Dispose();
	}

	public void Validate_Withdraw_Amount() {
		System.out.println("Validate the Amount to be withdraw");
	}

	public void Update_Amount() {
		System.out.println("Update the Amount after withdraw");
	}

	public void Cash_Dispose() {
		System.out.println("Dispose the cash from ATM");
	}

	public void Mini_Statement() {
		System.out.println("Get the mini statement");
	}
}
