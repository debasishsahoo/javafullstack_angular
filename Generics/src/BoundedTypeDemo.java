
public class BoundedTypeDemo {

	public static void main(String[] args) {
		Data<Integer> d1 = new Data<>(10);
        Data<Double> d2 = new Data<>(15.5);

        System.out.println(d1.doubleValue());
        System.out.println(d2.doubleValue());
        //Data<String> d3 = new Data<>("Hello");

	}

}
