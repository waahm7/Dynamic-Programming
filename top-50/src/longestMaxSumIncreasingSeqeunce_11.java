import java.util.Arrays;

public class longestMaxSumIncreasingSeqeunce_11 {

    static int LIS_length(int[] arr){
        int[] dp=new int[arr.length];
        int max=arr[0];
        dp[0]=arr[0];
        for (int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                dp[i]=arr[i];
                if(arr[j]<=arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                    if(dp[i]>max)
                        max=dp[i];
                }
            }

        }

        System.out.println(Arrays.toString(dp));
        return max;
    }


    public static void main(String[] agrs){
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };

        System.out.println(LIS_length(A));
    }
}