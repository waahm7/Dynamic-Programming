//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class minnumjump14 {

	public static boolean cutRod(int[] arr,int sum) {
		boolean dp[][]=new boolean[sum+1][arr.length+1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=true;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0]=false;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
					dp[i][j]=dp[i][j-1];
					if(i>=arr[j-1]) {
						dp[i][j]=dp[i-arr[j-1]][j-1]||dp[i][j-1];
					}
			}
		}
		
		return dp[sum][arr.length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,5,8,9,10,17,17,20}; 
		
		System.out.println(cutRod(a,317));
		
	}
	

}
