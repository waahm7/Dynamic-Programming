import java.util.Arrays;

public class sumOfSubMatrixInConstantTime_38 {

    public static int[][] preprocessSubMatrix(int[][] arr) {
        int[][] dp = new int[arr.length ][arr[0].length];
        for (int j = 1; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }

        for (int i=1;i<arr.length;i++) {
            for (int j = 1; j <arr[0].length; j++) {
                    dp[i][j]=dp[i-1][j]-dp[i-1][j-1]+dp[i][j-1]+arr[i][j];
            }
        }
        for(int a[]:dp)
            System.out.println(Arrays.toString(a));
        return dp;
    }

    public static void main(String[] args) {
        int[][] mat ={
                        { 0, 2, 5, 4, 1 },
                        { 4, 8, 2, 3, 7 },
                        { 6, 3, 4, 6, 2 },
                        { 7, 3, 1, 8, 3 },
                        { 1, 5, 7, 9, 4 }};
        int[][] preProcessed=preprocessSubMatrix(mat);
        int p = 1, q = 1, r = 3, s = 3;
        int total=preProcessed[r][s];
        if (q - 1 >= 0)
            total -= preProcessed[r][q - 1];
        if (p - 1 >= 0)
            total -= preProcessed[p - 1][s];
        if (p - 1 >= 0 && q - 1 >= 0)
            total += preProcessed[p - 1][q - 1];
        System.out.print(total);
    }
}
