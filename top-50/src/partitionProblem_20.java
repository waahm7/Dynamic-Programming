import java.util.Arrays;

public class partitionProblem_20 {

    public static boolean subsetSum(int[] arr,int sum){
        boolean[][] dp= new boolean[arr.length+1][sum+1];
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(j-arr[i-1]>=0)
                    dp[i][j]=dp[i][j] || dp[i-1][j-arr[i-1]];
                if(j==arr[i-1])
                    dp[i][j]=true;
            }
        }
//        for(boolean[] x:dp)
//            System.out.println(Arrays.toString(x));

        return dp[dp.length-1][dp[0].length-1];
    }
    public static boolean partition(int[] arr)
    {
        int sum = Arrays.stream(arr).sum();

        return (sum & 1) == 0 && subsetSum(arr, sum/2);
    }
     public static void main(String[] agrs){
         int[] arr = { 7, 3, 2, 5, 8 };
         System.out.println(partition(arr));
     }
}
