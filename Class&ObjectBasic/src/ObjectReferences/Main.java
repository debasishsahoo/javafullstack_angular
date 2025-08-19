package ObjectReferences;

class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}
public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("Alice");// p1 → object in heap
		Person p2 = p1;          // p2 points to the same object
		
		
		System.out.println(p1);
		System.out.println(p1.name);
		
		System.out.println(p2);
		System.out.println(p2.name);
		
		
		System.out.println(p1 == p2);       // true (same objects)
        System.out.println(p1.equals(p2));  // true (same state)
        //p1 and p2 are references stored in the stack.
        //Both point to the same object in the heap.
        //Changing the object via one reference reflects in the other.
        
        
        Person p3 = new Person("Alice");
        Person p4 = new Person("Alice");
        System.out.println(p3 == p4);// false (different objects in heap)
        //Even if state is the same, different new calls allocate separate heap memory
        
        
        Person p5 = null;
        System.out.println(p5);  // null
        System.out.println(p5.name); //NullPointerException
        //A null reference points to no object in memory.
        
        
        
        
        
        
        
	}
}
