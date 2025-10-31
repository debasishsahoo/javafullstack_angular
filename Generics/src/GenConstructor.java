
public class GenConstructor {
	private double val;

    <T extends Number> GenConstructor(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("Value: " + val);
    }
	
    public static void main(String[] args) {
        GenConstructor obj = new GenConstructor(100);
        obj.showVal();
    }
}
