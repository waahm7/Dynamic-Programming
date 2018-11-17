import java.util.Arrays;

public class LongestIncreasingSeqeunce_9 {

    static int LIS_length(int[] arr){
        int[] dp=new int[arr.length+1];
        dp[0]=0;
        if(arr[0]>=0)
            dp[1]=1;
        int max=1;
        for (int i=1;i<dp.length;i++){
            for(int j=i-1;j>0;j--){
                if(arr[j-1]<=arr[i-1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max)
                        max=dp[i];
                }
            }

        }

        System.out.println(Arrays.toString(dp));
        return max;
    }


    public static void main(String[] agrs){
        int[] A = { 0, 8, 4, 12, 2};

        System.out.println(LIS_length(A));
    }
}