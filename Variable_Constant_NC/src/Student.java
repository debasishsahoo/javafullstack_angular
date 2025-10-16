
public class Student extends Object{
	String name;
	Student(String name) {
        this.name = name;
    }
	@Override
    public String toString() {
        return "Student name: " + name;
    }
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return name.equals(s.name);
    }
	@Override
    public int hashCode() {
        return name.hashCode();
    }
	public static void main(String[] args) {
		Student s1=new Student("Debasish");
		Student s2=new Student("Dev");
		
		System.out.println(s1.toString());
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()); 
		System.out.println(s1.getClass());
		System.out.println("------------------");
		System.out.println(s2.toString());
		System.out.println(s2.equals(s2));
		System.out.println(s2.hashCode()); 
		System.out.println(s2.getClass());
		
		
	}

}
