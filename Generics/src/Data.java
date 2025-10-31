//Single Bound
public class Data<T extends Number> {
	private T value;

    public Data(T value) {
        this.value = value;
    }

    public double doubleValue() {
        return value.doubleValue();
    }
}
