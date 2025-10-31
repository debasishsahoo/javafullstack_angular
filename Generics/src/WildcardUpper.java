import java.util.List;

public class WildcardUpper {
	public static double sum(List<? extends Number> list) {
        double total = 0.0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }
	
	public static void main(String[] args) {
        List<Integer> intList = List.of(10, 20, 30);
        System.out.println("Sum = " + sum(intList));
    }
}
