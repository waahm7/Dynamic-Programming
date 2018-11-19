import java.util.Arrays;
import java.util.HashMap;

public class discreetKnapsack_18 {

    public static int knapsack(int[] v,int[] w,int W){
        int[][] dp= new int[v.length+1][W+1];
        for(int i=1;i<=v.length;i++){
            for(int j=1;j<=W;j++){
                dp[i][j]=dp[i-1][j];
                if(j-w[i-1]>=0)
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i-1]]+v[i-1]);
            }
        }
        for(int[] x:dp)
            System.out.println(Arrays.toString(x));

        return dp[dp.length-1][dp[0].length-1];
    }

     public static void main(String[] agrs){
         int[] v = { 20, 5, 10, 40, 15, 25 };
         int[] w = {  1, 2,  3,  8,  7, 4 };
         int W = 10;
         System.out.println(knapsack(v,w,W));
     }
}
