package NestedClasses;

public class Main {
	public static void main(String[] args) {
		// Accessing static nested class
		//Root Class.Static Class      objName=  new  Root Class.Static Class()
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();
        
        
        
        
        // Accessing inner class
        // obj of Outer Class
        OuterClass outer = new OuterClass();
        
        //Root Class.Inner Class  innerObj= outerobj.newInnerClass
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
	}
}
