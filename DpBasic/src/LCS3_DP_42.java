import java.util.*;
import java.lang.*;
import java.io.*;
class LCS3_DP_42 {
	
	public static  int lcs3(String a,String b,String c) {
		int[][][] dp=new int[a.length()+1][b.length()+1][c.length()+1];
		
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				dp[i][j][0]=0;
			}
		}
		for (int i = 0; i <= b.length(); i++) {
			for (int j = 0; j <= c.length(); j++) {
				dp[0][i][j]=0;
			}
		}
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= c.length(); j++) {
				dp[i][0][j]=0;
			}
		}
		
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				for (int j2 = 1; j2 <= c.length(); j2++) {
					
					if(a.charAt(i-1)==b.charAt(j-1)&&b.charAt(j-1)==c.charAt(j2-1))
						dp[i][j][j2]=1+dp[i-1][j-1][j2-1];
					else
						dp[i][j][j2]=Math.max(dp[i-1][j][j2],Math.max(dp[i][j-1][j2],dp[i][j][j2-1]));
					
				}
			}
		}
		
		
		return dp[a.length()][b.length()][c.length()];
		
	}
	
	
	public static void main (String[] args){
	 //code
	 Scanner scan=new Scanner(System.in);
	 int t=scan.nextInt();
	 for(int l=0;l<t;l++){
		 scan.nextInt();
		 scan.nextInt();
		 scan.nextInt();
		 System.out.println(lcs3(scan.next(),scan.next(),scan.next()));
	 
	 }
	 
	 
	 }//cls main
}