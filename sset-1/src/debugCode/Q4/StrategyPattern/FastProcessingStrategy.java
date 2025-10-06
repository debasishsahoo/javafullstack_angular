package debugCode.Q4.StrategyPattern;

public class FastProcessingStrategy implements ProcessingStrategy{
	 @Override
	    public void execute() {
	        System.out.println("Fast strategy execution");
	    }
}
