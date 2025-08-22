package StaticMembers;

public class MathUtils {
	public static final double PI = 3.14159;
    private static int instanceCount = 0;  //1
    
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public MathUtils() {
        instanceCount++; // Accessing static variable from instance context
    }
    
    
    
}
