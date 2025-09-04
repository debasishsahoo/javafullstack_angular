package InheritanceLimitations;

class DataProcessor {
	void processData() {
		// Complex processing logic
		System.out.println("Processing data");
	}
}
class AdvancedDataProcessor extends DataProcessor {
	@Override
	void processData() {
		// Depends on implementation details of parent
		super.processData();
		System.out.println("Additional processing");
	}
}



//Better approach using composition (loose coupling)
class BetterDataProcessor {
	private DataProcessor processor = new DataProcessor();
	
	void processData() {
        processor.processData();
        System.out.println("Additional processing");
    }
}

public class Rule1 {
	public static void main(String[] args) {
		// Tight Coupling
		AdvancedDataProcessor adp = new AdvancedDataProcessor();
		adp.processData();
		
		
		
		
		
		
		
		
		
		//loose coupling
		BetterDataProcessor bdp=new BetterDataProcessor();
		bdp.processData();
	}
}
