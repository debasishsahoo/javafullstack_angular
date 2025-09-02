package Type;

public class Singleton {
	private static Singleton instance;

	// Private constructor
	private Singleton() {
		// Only accessible within this class
	}

	// protected constructor
	protected Singleton(int i) {
		// Only accessible within this class
	}

	// Default constructor
	Singleton(String i) {
		// Only accessible within this class
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
