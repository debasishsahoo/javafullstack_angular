import java.util.ArrayList;
import java.util.List;

public class WildcardLower {
	public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        addIntegers(list);
        System.out.println(list);
    }

}
