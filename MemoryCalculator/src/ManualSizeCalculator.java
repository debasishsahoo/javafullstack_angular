import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ManualSizeCalculator {
    
    public static void main(String[] args) {
        System.out.println("🧮 Manual Memory Size Calculator");
        System.out.println("=" .repeat(50));
        
        // Test with different objects
        testObject("Hello World", "String");
        testObject(Integer.valueOf(42), "Integer");
        testObject(new int[100], "int[100] Array");
        testObject(new Person("John", 25), "Person Object");
        testObject(new Employee("Alice", 30, 50000), "Employee Object");
        
        // Compare primitive vs wrapper
        System.out.println("\n📊 Primitive vs Object Comparison:");
        System.out.println("-".repeat(40));
        System.out.println("int primitive: 4 bytes (in array or as field)");
        testObject(Integer.valueOf(42), "Integer object");
    }
    
    public static void testObject(Object obj, String description) {
        System.out.println("\n📋 " + description);
        System.out.println("-".repeat(30));
        
        if (obj.getClass().isArray()) {
            long size = calculateArraySize(obj);
            System.out.println("Estimated size: " + size + " bytes");
            System.out.println("Breakdown:");
            System.out.println("  - Object header: 16 bytes");
            System.out.println("  - Array length field: 4 bytes");
            
            if (obj instanceof int[]) {
                int[] arr = (int[]) obj;
                System.out.println("  - Elements (" + arr.length + " × 4): " + (arr.length * 4) + " bytes");
            } else if (obj instanceof Object[]) {
                Object[] arr = (Object[]) obj;
                System.out.println("  - References (" + arr.length + " × 8): " + (arr.length * 8) + " bytes");
            }
        } else {
            long size = calculateObjectSize(obj);
            System.out.println("Estimated size: " + size + " bytes");
            showObjectBreakdown(obj);
        }
    }
    
    public static long calculateObjectSize(Object obj) {
        if (obj == null) return 0;
        
        long size = 0;
        
        // Object header (mark word + class pointer + padding)
        size += 16; // Conservative estimate for 64-bit JVM
        
        Class<?> clazz = obj.getClass();
        
        // Add field sizes
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                size += getFieldSize(field.getType());
            }
        }
        
        // Align to 8-byte boundary (object padding)
        return alignTo8Bytes(size);
    }
    
    public static long calculateArraySize(Object array) {
        if (array == null || !array.getClass().isArray()) return 0;
        
        long size = 16; // Object header
        size += 4; // Array length field
        
        Class<?> componentType = array.getClass().getComponentType();
        int length = java.lang.reflect.Array.getLength(array);
        
        if (componentType.isPrimitive()) {
            size += length * getPrimitiveSize(componentType);
        } else {
            size += length * 8; // Reference size (assuming 64-bit with compressed OOPs)
        }
        
        return alignTo8Bytes(size);
    }
    
    private static void showObjectBreakdown(Object obj) {
        System.out.println("Breakdown:");
        System.out.println("  - Object header: 16 bytes");
        
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                long fieldSize = getFieldSize(field.getType());
                System.out.println("  - " + field.getName() + " (" + 
                                 field.getType().getSimpleName() + "): " + fieldSize + " bytes");
            }
        }
        
        long totalFieldSize = 0;
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                totalFieldSize += getFieldSize(field.getType());
            }
        }
        
        long withHeader = 16 + totalFieldSize;
        long aligned = alignTo8Bytes(withHeader);
        long padding = aligned - withHeader;
        
        if (padding > 0) {
            System.out.println("  - Padding: " + padding + " bytes");
        }
    }
    
    private static long getFieldSize(Class<?> type) {
        if (type == boolean.class || type == byte.class) return 1;
        if (type == char.class || type == short.class) return 2;
        if (type == int.class || type == float.class) return 4;
        if (type == long.class || type == double.class) return 8;
        return 8; // Reference size (assuming 64-bit with compressed OOPs)
    }
    
    private static long getPrimitiveSize(Class<?> type) {
        if (type == boolean.class || type == byte.class) return 1;
        if (type == char.class || type == short.class) return 2;
        if (type == int.class || type == float.class) return 4;
        if (type == long.class || type == double.class) return 8;
        return 0;
    }
    
    private static long alignTo8Bytes(long size) {
        return (size + 7) & ~7;
    }
}

// Person class removed - using the one from MemoryCalculator or separate Person.java

class Employee extends Person {
    private double salary;  // 8 bytes
    private boolean active; // 1 byte
    
    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
        this.active = true;
    }
}