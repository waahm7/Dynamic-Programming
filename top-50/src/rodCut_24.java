import java.util.HashMap;
import java.util.Map;

public class rodCut_24 {

    public static int rodCut(int[] arr,int n) {
        int[] dp = new int[n + 1];
        for (int i=0;i<=n;i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Integer.max(dp[i], arr[j - 1] + dp[i - j]);

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 4;

        System.out.print("Profit is " + rodCut(price, n));
    }
}
