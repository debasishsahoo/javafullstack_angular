package debugCode.Q4.SingletonPattern;

public class DefaultProcessor implements Processor {
	private static final DefaultProcessor INSTANCE = new DefaultProcessor();

	private DefaultProcessor() {
	}

	public static DefaultProcessor getInstance() {
		return INSTANCE;
	}

	@Override
	public void process() {
		System.out.println("Safe processing");
	}
}