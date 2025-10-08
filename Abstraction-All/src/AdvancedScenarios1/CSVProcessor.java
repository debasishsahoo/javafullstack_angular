package AdvancedScenarios1;

public class CSVProcessor extends DataProcessor {
	private int recordCount = 0;

	@Override
	void processData() {
		System.out.println("Processing CSV data...");
		recordCount = 100;
	}
	@Override
    String getStatus() {
        return "CSV Processing Complete";
    }
    
    @Override
    int getRecordCount() {
        return recordCount;
    }
    
    @Override
    Result getResult() {
        return new Result(true, "CSV processed successfully");
    }
    
    @Override
    boolean validateData(String data, int threshold) {
        return data != null && data.length() > threshold;
    }

}
