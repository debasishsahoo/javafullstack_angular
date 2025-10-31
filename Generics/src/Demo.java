
//Multiple Bounds
public class Demo <T extends Number & Comparable<T>>{
	 T value;

	    Demo(T value) {
	        this.value = value;
	    }
}
