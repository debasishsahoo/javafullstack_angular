import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuntimeMemoryMonitor {
    
    public static void main(String[] args) {
        System.out.println("📊 Runtime Memory Monitoring");
        System.out.println("=" .repeat(60));
        
        // Show initial memory state
        showMemoryInfo("Initial State");
        
        // Test different object creation scenarios
        measureMemoryUsage("String creation (1000 strings)", () -> {
            String[] strings = new String[1000];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = "String " + i;
            }
        });
        
        measureMemoryUsage("Integer array creation (10,000 elements)", () -> {
            int[] array = new int[10000];
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
            }
        });
        
        measureMemoryUsage("ArrayList with 5000 Integer objects", () -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5000; i++) {
                list.add(Integer.valueOf(i));
            }
        });
        
        measureMemoryUsage("HashMap with 1000 entries", () -> {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < 1000; i++) {
                map.put("key" + i, i);
            }
        });
        
        measureMemoryUsage("Person objects creation (2000 objects)", () -> {
            Person[] people = new Person[2000];
            for (int i = 0; i < people.length; i++) {
                people[i] = new Person("Person" + i, 20 + (i % 50));
            }
        });
        
        // Memory leak simulation (commented out to avoid issues)
        // measureMemoryUsage("Memory leak simulation", () -> {
        //     List<byte[]> memoryHog = new ArrayList<>();
        //     for (int i = 0; i < 100; i++) {
        //         memoryHog.add(new byte[1024 * 1024]); // 1MB each
        //     }
        // });
        
        // Show final memory state
        showMemoryInfo("Final State");
        
        // Demonstrate garbage collection effect
        System.out.println("\n🗑️ Garbage Collection Demo:");
        System.out.println("-".repeat(40));
        showMemoryInfo("Before GC");
        System.gc();
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        showMemoryInfo("After GC");
    }
    
    public static void measureMemoryUsage(String description, Runnable task) {
        Runtime runtime = Runtime.getRuntime();
        
        // Clean up before measurement
        System.gc();
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        long beforeTotal = runtime.totalMemory();
        
        // Execute the task
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        
        // Measure after (without GC to see actual allocation)
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        long afterTotal = runtime.totalMemory();
        
        long memoryUsed = afterMemory - beforeMemory;
        long heapGrowth = afterTotal - beforeTotal;
        long timeElapsed = endTime - startTime;
        
        System.out.println("\n📈 " + description);
        System.out.println("-".repeat(50));
        System.out.println("Memory allocated: " + formatBytes(memoryUsed));
        if (heapGrowth > 0) {
            System.out.println("Heap expanded by: " + formatBytes(heapGrowth));
        }
        System.out.println("Time taken: " + formatTime(timeElapsed));
        System.out.println("Allocation rate: " + formatBytes(memoryUsed * 1_000_000_000L / timeElapsed) + "/sec");
        
        // Show memory state after operation
        showMemoryInfo("After " + description);
    }
    
    public static void showMemoryInfo(String label) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();
        
        System.out.println("\n💾 " + label);
        System.out.println("Used:  " + formatBytes(usedMemory) + 
                          " (" + String.format("%.1f", (usedMemory * 100.0 / totalMemory)) + "% of heap)");
        System.out.println("Free:  " + formatBytes(freeMemory));
        System.out.println("Total: " + formatBytes(totalMemory));
        System.out.println("Max:   " + formatBytes(maxMemory));
    }
    
    private static String formatBytes(long bytes) {
        if (bytes < 0) return "N/A";
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }
    
    private static String formatTime(long nanos) {
        if (nanos < 1_000) return nanos + " ns";
        if (nanos < 1_000_000) return String.format("%.1f μs", nanos / 1_000.0);
        if (nanos < 1_000_000_000) return String.format("%.1f ms", nanos / 1_000_000.0);
        return String.format("%.1f s", nanos / 1_000_000_000.0);
    }
}

// Person class removed - using the one from MemoryCalculator or separate Person.java