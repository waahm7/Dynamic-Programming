//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class subsetsum13 {

	public static boolean cutRod(int[] arr,int sum) {
		boolean dp[][]=new boolean[arr.length+1][sum+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0]=true;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=false;
		}
		dp[0][0]=true;
		
		
		
		return dp[sum][arr.length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,5,8,9,10,17,17,20}; 
		
		System.out.println(cutRod(a,15));
		
	}
	

}
