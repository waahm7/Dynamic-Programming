
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 class maxPathSum48 {

	public static long pathWithMaxCost(int[][] n) {

		int[][] dp=new int[n.length][n[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=n[0][i];
		}
		long max=Long.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j]=0;
				if(j==0) {
					dp[i][j]=n[i][j]+Math.max(dp[i-1][j],dp[i-1][j+1]);
				}
				else if(j==dp[0].length-1) {
					dp[i][j]=n[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
						
				}
				else {
					dp[i][j]=n[i][j]+Math.max(dp[i-1][j],Math.max(dp[i-1][j+1],dp[i-1][j-1]));
					
				}
				if(i==dp.length-1&&max<dp[i][j]) {
					max=dp[i][j];
				}
			}
			
		}
		
		

		return max;
	}



	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] mat = { {4, 2, 3, 4},
                 {2, 9, 1, 10},
                 {15, 1, 3, 0},
                 {16, 92, 150, 44} };
	
		 System.out.println(pathWithMaxCost(mat));
	}

}
