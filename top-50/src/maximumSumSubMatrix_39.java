import java.util.Arrays;

public class maximumSumSubMatrix_39 {

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
    public static int getTotal(int[][] preProcessed,int p,int q,int r,int s){
        int total=preProcessed[r][s];
        if (q - 1 >= 0)
            total -= preProcessed[r][q - 1];
        if (p - 1 >= 0)
            total -= preProcessed[p - 1][s];
        if (p - 1 >= 0 && q - 1 >= 0)
            total += preProcessed[p - 1][q - 1];
        return total;
    }
    public static void main(String[] args) {
        int[][] mat = {
                        { 3, -4, 6, -5, 1 },
                        { 1, -2, 8, -4, -2 },
                        { 3, -8, 9, 3, 1 },
                        { -7, 3, 4, 2, 7 },
                        { -3, 7, -5, 7, -6 }};
        int[][] preProcessed=preprocessSubMatrix(mat);
        int k=3,max=-1;
        for (int i=k-1;i<mat.length;i++){
            for(int j=k-1;j<mat[0].length;j++){
                int total=getTotal(preProcessed,i-k+1,j-k+1,i,j);
                if(total>max)
                    max=total;

            }
        }
        System.out.print(max);
    }
}
