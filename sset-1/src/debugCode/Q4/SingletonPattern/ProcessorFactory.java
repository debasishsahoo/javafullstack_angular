package debugCode.Q4.SingletonPattern;

public class ProcessorFactory {
	
	public static Processor getProcessor(String type) {
        return switch (type) {
            case "fast" -> FastProcessor.getInstance();
            case "safe" -> SafeProcessor.getInstance();
            default -> DefaultProcessor.getInstance();
        };
    }
	
	
	
	

	public static void main(String[] args) {
		

	}

}
