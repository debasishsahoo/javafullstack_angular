
public class Dog extends Animal {
	public Dog() {
        super(); // Implicit call to parent constructor
        System.out.println("Dog constructor");
    }
	 public static void main(String[] args) {
		 Dog d = new Dog();
	 }
}
