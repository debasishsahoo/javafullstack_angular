import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class MemoryUtils {
    
    // Suppress the JOL warning by setting system property
    static {
        System.setProperty("jdk.attach.allowAttachSelf", "true");
    }
    
    public static void quickAnalysis(Object obj) {
        String className = obj.getClass().getSimpleName();
        long shallow = ClassLayout.parseInstance(obj).instanceSize();
        long deep = GraphLayout.parseInstance(obj).totalSize();
        
        System.out.printf("%-15s | Shallow: %3d bytes | Deep: %3d bytes%n", 
                         className, shallow, deep);
    }
    
    public static void compareObjects(Object... objects) {
        System.out.println("\n Memory Comparison:");
        System.out.println("Object Type     | Shallow Size | Deep Size");
        System.out.println("----------------|-------------|----------");
        
        for (Object obj : objects) {
            quickAnalysis(obj);
        }
    }
    
    public static void detailedAnalysis(Object obj, String description) {
        System.out.println("\n=== " + description + " ===");
        
        long shallowSize = ClassLayout.parseInstance(obj).instanceSize();
        System.out.println("Shallow size: " + shallowSize + " bytes");
        
        long deepSize = GraphLayout.parseInstance(obj).totalSize();
        System.out.println("Deep size: " + deepSize + " bytes");
        
        System.out.println("\nDetailed Layout:");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println();
    }
}