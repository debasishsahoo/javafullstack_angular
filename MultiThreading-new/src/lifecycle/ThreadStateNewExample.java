package lifecycle;

//the thread object has been created
//Exists in memory.
//Has not been scheduled by the CPU.
//Is not performing any task yet.
public class ThreadStateNewExample {

	public static void main(String[] args) {
		//The thread object t has been created.
		 Thread t = new Thread(() -> {
	            System.out.println("Running");
	            //Since t.start() is not called yet, it remains in the NEW state.
	        });
		 System.out.println("Thread state before start(): " + t.getState());
	}
//Only after calling start() does it move to the RUNNABLE state.
}
