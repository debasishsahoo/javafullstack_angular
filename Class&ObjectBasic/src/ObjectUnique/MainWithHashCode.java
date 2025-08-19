package ObjectUnique;
class Human {
    String name;
    int age;
    
    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human p = (Human) o;
        return age == p.age && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}

public class MainWithHashCode {
	public static void main(String[] args) {
		Human p1 = new Human("Alice", 25);
		Human p2 = new Human("Alice", 25);

        System.out.println(p1 == p2);       // false (different objects)
        System.out.println(p1.equals(p2));  // true (same state)
    }
}

//Physical uniqueness: Every new object has a unique reference.
//Logical uniqueness: Can be controlled via equals() and hashCode() methods.
