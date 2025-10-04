package debugCode.Q4.SingletonPattern;

public class SafeProcessor implements Processor {
	private static final SafeProcessor INSTANCE = new SafeProcessor();

	private SafeProcessor() {
	}

	public static SafeProcessor getInstance() {
		return INSTANCE;
	}

	@Override
	public void process() {
		System.out.println("Safe processing");
	}
}
