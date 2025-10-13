package Hierarchy;


//java.lang.Object
//└── java.lang.Throwable
//        ├── java.lang.Error
//        └── java.lang.Exception
//                ├── RuntimeException (unchecked)
//                └── Other Exceptions (checked)

//Throwable:(java.lang.Throwable)
//superclass of all errors and exceptions in Java
//Only objects that are instances of this class (or its subclasses) 
//can be thrown by the JVM or by a throw statement.

//Error:(java.lang.Error)
    //represents serious problems that applications should not try to catch.
    //These are typically external to the application and 
    //indicate critical issues that prevent normal program execution.

    //OutOfMemoryError - JVM runs out of memory
    //StackOverflowError - stack space exhausted (often from infinite recursion)
    //VirtualMachineError - JVM is broken or has run out of resources
    //AssertionError - assertion failed
    //LinkageError - class loading or linking issues

//Exception:Exception represents conditions that applications should catch and handle.
//RuntimeException (Unchecked Exceptions)
//These extend RuntimeException and represent programming errors
//- `NullPointerException`
//- `ArrayIndexOutOfBoundsException`
//- `ClassCastException`
//- `IllegalArgumentException`
//- `IllegalStateException`
//- `NumberFormatException`
//- `ArithmeticException`
//- `UnsupportedOperationException`

//Checked Exceptions
//All Exception subclasses that don't extend RuntimeException are checked:

//IOException
//  FileNotFoundException
//  EOFException
//  SocketException
//SQLException
//ClassNotFoundException
//InterruptedException
//ParseException
//CloneNotSupportedException

















public class Hierarchy {

}
