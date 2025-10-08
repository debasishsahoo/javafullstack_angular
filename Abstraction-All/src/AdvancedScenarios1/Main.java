package AdvancedScenarios1;

public class Main {
	public static void main(String[] args) {
		// Create an object of CSVProcessor (concrete subclass)
		DataProcessor processor = new CSVProcessor();

		// Call abstract method implementations
		processor.processData();

		System.out.println("Status: " + processor.getStatus());
		System.out.println("Record Count: " + processor.getRecordCount());

		// Get result object and display details
		Result result = processor.getResult();
		System.out.println("Result Success: " + result.isSuccess());
		System.out.println("Result Message: " + result.getMessage());

		// Validate some data
		String sampleData = "sample,record,data";
		boolean isValid = processor.validateData(sampleData, 5);
		System.out.println("Data Valid: " + isValid);
	}
}
