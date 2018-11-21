import java.util.Arrays;

public class rodCutProduct_25 {

    public static int rodCut(int n) {
        int[] dp = new int[n + 1];
        for(int i=0;i<dp.length;i++){
            dp[i]=i;
        }
        System.out.println(Arrays.toString(dp));
         for(int i=2;i<dp.length;i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Integer.max(dp[i], j * dp[i - j]);

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int n=15;
        System.out.print("Profit is " + rodCut(n));
    }
}
