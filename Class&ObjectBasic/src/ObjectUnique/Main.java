package ObjectUnique;

class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//Every time you create an object using new, 
//Java allocates separate memory in the heap for it.
//Even if two objects have identical field values, they are different objects.
//Each object has a unique reference (memory address).
public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25); // Same state as p1
        
        System.out.println(p1 == p2);        // false (different objects)
        
        System.out.println(p1.equals(p2));   // false (unless equals() overridden)
        
        System.out.println(p1);              // prints reference
        
        System.out.println(p2);              // prints different reference
        
        
	}
}
//p1 == p2 → false because == compares references, not values.
//p1.equals(p2) → false by default, because Object.equals() also compares references.
//Even with identical state (name and age), these are two distinct objects in memory.




