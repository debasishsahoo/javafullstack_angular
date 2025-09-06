
public class StringBuilder {
	private String value = "";

	public StringBuilder append(String str) {
		if (str != null) {
			this.value += str;
		}

		return this; // Returns current object for chaining
	}

	public StringBuilder reverse() {
		String reversed = "";
		for (int i = value.length() - 1; i >= 0; i--) {
			reversed += value.charAt(i);
		}
		this.value = reversed;
		return this;
	}
	
	@Override
    public String toString() {
        return value;
    }
	
	public static void main(String[] args) {
		StringBuilder builder=new StringBuilder();
		builder.append("Hello").append("World").reverse();
		System.out.println(builder); // Output: dlroW olleH
	}
	
}
