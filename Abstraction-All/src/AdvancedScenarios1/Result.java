package AdvancedScenarios1;

public class Result {
	private boolean success;
	private String message;

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	// Getters
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
