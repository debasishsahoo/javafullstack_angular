package StartVsRun;

public class Demo {
	
	public synchronized void start() {
	    // Check if thread is already started
	    if (threadStatus != 0)
	        throw new IllegalThreadStateException();

	    // Add to thread group
	    group.add(this);

	    boolean started = false;
	    try {
	        start0(); // Native method - creates OS thread
	        started = true;
	    } finally {
	        // Cleanup if start failed
	    }
	}

	private native void start0(); // JVM creates new thread and calls run()

	
	@Override
	public void run() {
	    if (target != null) {
	        target.run(); // Just executes the Runnable's run() method
	    }
	}

	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
