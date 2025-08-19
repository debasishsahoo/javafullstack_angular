import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class MemoryCalculator {
	public static void main(String[] args) {
		// Add this line at the very beginning to suppress the warning
		System.setProperty("jdk.attach.allowAttachSelf", "true");

		System.out.println(" Java Object Memory Analysis");
		System.out.println("=".repeat(60));

		// Test with different objects
		analyzeObject("Hello World", "String");
		analyzeObject(Integer.valueOf(42), "Integer");
		analyzeObject(new int[100], "int[100] Array");
		analyzeObject(new Person("John", 25), "Person Object");

		// Additional interesting objects
		analyzeObject(new StringBuilder("Test"), "StringBuilder");
		analyzeObject(new java.util.ArrayList<>(), "Empty ArrayList");

		// Using the utility class methods
		// Quick comparison
		MemoryUtils.compareObjects("Hello World", Integer.valueOf(42), new int[100], new Person("John", 25));
		// Detailed analysis
		MemoryUtils.detailedAnalysis("Hello World", "String Analysis");
		MemoryUtils.detailedAnalysis(new Person("Alice", 30), "Person Analysis");

	}

	public static void analyzeObject(Object obj, String description) {
		System.out.println("\n " + description);
		System.out.println("-".repeat(40));

		try {
			// Shallow size (object itself only)
			long shallowSize = ClassLayout.parseInstance(obj).instanceSize();
			System.out.println("Shallow size: " + formatBytes(shallowSize));

			// Deep size (including referenced objects)
			long deepSize = GraphLayout.parseInstance(obj).totalSize();
			System.out.println("Deep size:    " + formatBytes(deepSize));

			// Show overhead
			long overhead = deepSize - shallowSize;
			if (overhead > 0) {
				System.out.println("Overhead:     " + formatBytes(overhead) + " ("
						+ String.format("%.1f", (overhead * 100.0 / deepSize)) + "%)");
			}

			// Compact layout view
			System.out.println("\n Object Structure:");
			String layout = ClassLayout.parseInstance(obj).toPrintable();

			// Clean up the layout output - show only essential info
			String[] lines = layout.split("\n");
			for (String line : lines) {
				if (line.contains("OFF SZ TYPE DESCRIPTION") || line.contains("object header")
						|| line.contains("Instance size") || line.contains("Space losses")
						|| (!line.trim().isEmpty() && !line.contains("VALUE") && !line.contains("object internals")
								&& !line.contains("=="))) {
					System.out.println("  " + line);
				}
			}

		} catch (Exception e) {
			System.out.println(" Error analyzing object: " + e.getMessage());
		}
	}

	private static String formatBytes(long bytes) {
		if (bytes == 0)
			return "0 bytes";
		if (bytes < 1024)
			return bytes + " bytes";
		if (bytes < 1024 * 1024)
			return String.format("%.1f KB (%d bytes)", bytes / 1024.0, bytes);
		return String.format("%.1f MB (%d bytes)", bytes / (1024.0 * 1024), bytes);
	}

}

//Sample class for testing
class Person {
	private String name;
	private int age;
	private static final String DEFAULT_COUNTRY = "Unknown"; // Static field - not counted per instance

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "}";
	}
}
