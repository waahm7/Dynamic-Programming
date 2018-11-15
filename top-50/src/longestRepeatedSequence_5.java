public class longestRepeatedSequence_5 {


    static int LCS_length(String str1,String str2){
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<dp.length;i++)
            dp[i][0]=0;
        for (int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        for (int i=1;i<dp.length;i++)
            for (int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)&&i!=j)
                    dp[i][j]=1+dp[i-1][j-1];
                dp[i][j]=Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
            }


        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] agrs){

        System.out.println(LCS_length("ATACTCGGA","ATACTCGGA"));
    }
}