import java.util.List;

//Wildcards are ? and are used when the exact type is unknown.
public class WildcardDemo {
	public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

	public static void main(String[] args) {
		List<Integer> ints = List.of(1, 2, 3);
        List<String> strs = List.of("A", "B");
        printList(ints);
        printList(strs);

	}

}
