public class MemoryTestSuite {
    
    public static void main(String[] args) {
        System.out.println("🔬 Complete Memory Analysis Suite");
        System.out.println("=" .repeat(60));
        
        // Test object for all methods
        String testString = "Hello World";
        Person testPerson = new Person("Alice", 30);
        
        System.out.println("1️⃣ MANUAL CALCULATION:");
        ManualSizeCalculator.testObject(testString, "String");
        ManualSizeCalculator.testObject(testPerson, "Person");
        
        System.out.println("\n2️⃣ RUNTIME MONITORING:");
        RuntimeMemoryMonitor.measureMemoryUsage("Creating test objects", () -> {
            for (int i = 0; i < 1000; i++) {
                new Person("Person" + i, i % 100);
            }
        });
        
        System.out.println("\n3️⃣ JOL ANALYSIS (if available):");
        // Add JOL analysis here if you want to compare
    }
}