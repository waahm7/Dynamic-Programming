
import java.util.Scanner;

public class BinarySequence23 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		System.out.println(countWays(n));
	
	}
	
	public static int countWays(int n) {
	//	n=(int) Math.pow(2,n);
	//	System.out.println(n);
		int nfact=Utility.factorial(n);
		int sum=0; 
		for (int i = 0; i <=n; i++) {
			int a=nfact/(Utility.factorial(i)*Utility.factorial(n-i));
			sum+=a*a;
		}
	
		return sum;
	}
	

}
