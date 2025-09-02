package Multiple_Inheritance;

interface CanRun {
	default void run() {
        System.out.println("Running fast");
    }
}
