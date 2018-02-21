
import java.util.Scanner;

public class TillingProblem22 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		System.out.println(countWays(n+1));
	
	}
	
	public static int countWays(int n) {
		if(n<1)
			return 0;
		//vertical 
		if(n<2)
			return 1;
		else
			return countWays(n-1)+countWays(n-2);
	}

}
