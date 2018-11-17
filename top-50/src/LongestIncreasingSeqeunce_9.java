import java.util.Arrays;

public class LongestIncreasingSeqeunce_9 {

    static int LIS_length(int[] arr){
        int[] dp=new int[arr.length+1];
        dp[0]=0;
        if(arr[0]>=0)
            dp[1]=1;
        for (int i=1;i<dp.length;i++){
            for(int j=i-1;j>0;j--){
                if(arr[j-1]<=arr[i-1])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }

        }

        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }


    public static void main(String[] agrs){
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(LIS_length(A));
    }
}