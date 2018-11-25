public class numSolutionToLinearEquation_34 {

    public static int maxSoltions(int[] arr,int n) {
        int[] dp = new int[n + 1];
        for (int i=0;i<=n;i++)
            for (int j = 0; j < arr.length; j++)
                if(i-arr[j]>=0)
                    dp[i]=Math.max(dp[i],dp[i-arr[j]]+1);
                else
                    break;
        return dp[n];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 3,5,7 };
        int rhs = 8;

        System.out.print(maxSoltions(coins, rhs));
    }
}
