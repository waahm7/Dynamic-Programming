
import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class fillGrid28 {

	public static long cutRod(int n) {
		
		if(n<4)
			return 1;
		else if(n==4)
			return 2;
		else {
			long[] arr=new long[n+1];
			arr[0]=0;
			arr[1]=1;
			arr[2]=1;
			arr[3]=1;
			arr[4]=2;
			for (int i = 5; i < arr.length; i++) {
				arr[i]=arr[i-1]+arr[i-4];
			}
			return arr[arr.length-1];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 int t=scan.nextInt();
		 for(int l=0;l<t;l++){
		 
			 int n=scan.nextInt();
			System.out.println(cutRod(n));
				
							 
		 }
		 
		
	}
	

}
