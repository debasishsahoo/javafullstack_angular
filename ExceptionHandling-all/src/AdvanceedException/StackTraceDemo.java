package AdvanceedException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class StackTraceDemo {
	private static void method1() throws Exception {
		method2();
	}

	private static void method2() throws Exception {
		method3();
	}

	private static void method3() throws Exception {
		throw new Exception("Error in method3");
	}

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			// Different ways to handle stack traces
			// 1. Print to console
			
			//e.printStackTrace();

			// 2. Get stack trace as string
			
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
//			String stackTrace = sw.toString();
			
			// 3. Programmatically access stack trace
			
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                System.out.println("Class: " + element.getClassName());
                System.out.println("Method: " + element.getMethodName());
                System.out.println("Line: " + element.getLineNumber());
                System.out.println("File: " + element.getFileName());
                System.out.println("---");
            }
			
			// 4. Get current stack trace (without exception)
//            StackTraceElement[] currentStack = Thread.currentThread().getStackTrace();
//            System.out.println(currentStack);
			
			
			// 5. Filter stack trace
//            StackTraceElement[] filtered = Arrays.stream(e.getStackTrace())
//                .filter(el -> el.getClassName().startsWith("com.mycompany"))
//                .toArray(StackTraceElement[]::new);
//            e.setStackTrace(filtered);
			
			
			
			
			
			
			
			

		}

	}

}
