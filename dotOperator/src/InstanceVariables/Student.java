package InstanceVariables;

public class Student {
	public String name;
    private int age;   
    protected String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }
}
