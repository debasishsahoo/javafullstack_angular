package MethodChaining;

public class MyStringBuilder {
	 private String value = "";

	    public MyStringBuilder append(String str) {
	        value += str;// value=value+str;
	        return this; // Returns current object for chaining
	    }
	    // Hello World!

	    public MyStringBuilder reverse() {
	        value = new StringBuilder(value).reverse().toString();
	        return this;
	    }
	    //!dlroW olleH
	    
	
	    @Override
	    public String toString() {
	        return value;
	    }
}
