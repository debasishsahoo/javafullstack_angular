import java.util.Scanner;

public class MethodExample2 {

	//Flow of Execution
	public static float pi() {
		return 3.142f;
	}
	
	public static int sum(int a,int b) {
		int c;
		c=a+b;
		return c;
	}
	
	public static void simpleinterest(int p,float r,int t)
    {
        float si;
        si=(p*r*t)/100;
        System.out.println("Simple Interest = " + si);
    }
	
	public static void main(String[] args) {
		int x=10, y=20, z;
		System.out.println("The Value of PI is 22/7="+pi());
		z=sum(x,y);
		System.out.println("Sum of "+ x +" and "+ y +" is "+z);
		
		
		int principal,time;
        float rate;
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        principal=sc.nextInt();
        System.out.print("Enter yearly rate %: ");
        rate=sc.nextFloat();
        System.out.print("Enter time in year: ");
        time=sc.nextInt();
        simpleinterest(principal,rate,time);
		
	}

}
