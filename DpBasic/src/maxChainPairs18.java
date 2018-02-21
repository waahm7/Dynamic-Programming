import java.util.Arrays;
import java.util.Scanner;

public class maxChainPairs18 {

	public static int cutRod(int[] arr) {
		int[] dp=new int[arr.length+1];
		Arrays.fill(dp,0);
		if(arr[0]==0)
			return -1;
		dp[1]=1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < arr[i-1]&&i+j+1<dp.length; j++) {
				if(dp[i]!=0) {
					if(dp[i+j+1]==0)
						dp[i+j+1]=dp[i]+1;
					else
						dp[i+j+1]=Math.min(dp[i]+1,dp[i+j+1]);
				}
			}
		}
		if(dp[arr.length]==0)
			return -1;
		return dp[arr.length]-1;
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		///	int a[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};

		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for (int l = 0; l < t; l++) {
			int n=scan.nextInt();
			int[] a=new int[n];
			for (int i = 0; i <n; i++) {
				a[i]=scan.nextInt();
			}

			System.out.println(cutRod(a));
			
		}
		
		
	}
	

}
