package AdvancedScenarios1;

public abstract class DataProcessor {
	// Abstract method returning void
	abstract void processData();

	// Abstract method returning String
	abstract String getStatus();

	// Abstract method returning int
	abstract int getRecordCount();

	// Abstract method returning custom object
	abstract Result getResult();

	// Abstract method with parameters
	abstract boolean validateData(String data, int threshold);
}
