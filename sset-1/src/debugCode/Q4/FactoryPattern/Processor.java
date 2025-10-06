package debugCode.Q4.FactoryPattern;

public abstract class Processor {
	public abstract void process();

	// Polymorphic factory method
	public static Processor createProcessor(String type) {
		switch (type) {
		case "fast":
			return new FastProcessor();
		case "safe":
			return new SafeProcessor();
		default:
			return new DefaultProcessor();
		}
	}
}
