package Multiple_Inheritance;

interface CanSwim {
	default void swim() {
        System.out.println("Swimming gracefully");
    }
}
