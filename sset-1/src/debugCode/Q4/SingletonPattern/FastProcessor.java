package debugCode.Q4.SingletonPattern;

public class FastProcessor implements Processor {
	private static final FastProcessor INSTANCE = new FastProcessor();

	private FastProcessor() {
	}

	public static FastProcessor getInstance() {
		return INSTANCE;
	}

	@Override
	public void process() {
		System.out.println("Fast processing");
	}
}
