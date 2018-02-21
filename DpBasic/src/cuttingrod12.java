import java.util.Arrays;
import java.util.Scanner;

public class cuttingrod12 {

	public static class Pair implements Comparable<Pair>{
		int a,b;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return b-o.a;
		}
		
	}
	
	public static int cutRod(Pair[] arr) {
		int[] dp=new int[arr.length];
		dp[0]=0;
		int max=0;
		for (int i = 1; i < arr.length; i++) {
			dp[i]=0;
			for (int j = 0; j < i; j++) {
				//arr[j]<arr[i]
				//	b < a	
				if(arr[j].b<arr[i].a) {
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//	int a[] =  {10, 5, 4, 3,10};

		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for (int l = 0; l < t; l++) {
			int n=scan.nextInt();
			Pair[] a=new Pair[n];
			for (int i = 0; i <n; i++) {
				a[i]=new Pair();
				a[i].a=scan.nextInt();
				a[i].b=scan.nextInt();
			}

			System.out.println(cutRod(a)+1);
			
		}
		
		
	}
	

}
