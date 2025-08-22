package MethodChaining;

public class Main {
	public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();

        // Method chaining using dot operator
        String result = sb.append("Hello") //"Hello"
                         .append(" ") //"Hello "
                         .append("World")//"Hello World"
                         .append("!")//"Hello World!"
                         .reverse()
                         .toString();

        System.out.println(result); // "!dlroW olleH"
    }
}
