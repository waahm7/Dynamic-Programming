import java.util.Arrays;

public class maximumSizeSquareInMatrix_13 {

    public static int maxMatrix(int[][] arr) {
        int[][] dp = new int[arr.length + 1][arr[0].length+1];
        int max=0;
        for (int i=1;i<=arr.length;i++) {
            for (int j = 1; j <= arr[0].length; j++) {
                if(arr[i-1][j-1]==1){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    if(dp[i][j]>max)
                        max=dp[i][j];
                }
            }
        }
        for(int a[]:dp)
            System.out.println(Arrays.toString(a));
        return max;
    }

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};


        System.out.print(maxMatrix(M));
    }
}
