package debugCode.Q4.StrategyPattern;

public class ProcessingContext {
	   private ProcessingStrategy strategy;
	   
	   
	   public ProcessingContext(ProcessingStrategy strategy) {
	        this.strategy = strategy;
	    }
	   
	   public void setStrategy(ProcessingStrategy strategy) {
	        this.strategy = strategy;
	    }

	    public void executeProcessing() {
	        strategy.execute();  // True polymorphism
	    }
	    
	 // Class-level factory method
	    public static ProcessingContext createDefault() {
	        return new ProcessingContext(new FastProcessingStrategy());
	    }
}
