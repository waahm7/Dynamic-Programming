import java.util.Arrays;

public class matrixChainMultiplication_14 {

    public static int matrixChainMultiplication(int[] dims) {
        int n = dims.length;

        // c[i,j] = minimum number of scalar multiplications (i.e., cost)
        // needed to compute the matrix M[i]M[i+1]...M[j] = M[i..j]
        // The cost is zero when multiplying one matrix
        int[][] c = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                c[i][j] = Integer.MAX_VALUE;
                for (int k = i; j < n && k <= j - 1; k++) {
                    int cost = c[i][k] + c[k + 1][j]
                            + dims[i - 1] * dims[k] * dims[j];
                    if (cost < c[i][j])
                        c[i][j] = cost;

                }
            }
        }
        return c[1][n - 1];
    }


    public static void main(String[] agrs){
        int[] dims = { 10, 30, 5, 60 };

        System.out.println(matrixChainMultiplication(dims));
    }
}