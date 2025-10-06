package debugCode.Q4.FactoryPattern;

public class Main4 {
	public static void main(String[] args) {
		// Usage - proper polymorphism
		Processor processor = Processor.createProcessor("fast");
		processor.process();  // Calls FastProcessor.process() - true polymorphism
	}
}
