package debugCode.Q4.EnumPattern;

public class Main5 {

	public static void main(String[] args) {
		// Usage
		ProcessorType processor = ProcessorType.SAFE;
		processor.process(); // Polymorphic call to the enum constant's implementation

	}

}
