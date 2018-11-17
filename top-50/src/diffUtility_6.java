public class diffUtility_6 {


    static int LCS_length(String str1,String str2){
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for (int i=0;i<dp.length;i++)
            dp[i][0]=0;
        for (int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        for (int i=1;i<dp.length;i++)
            for (int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                dp[i][j]=Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
            }

        printDiff(str1,str2,str1.length(),str2.length(),dp);
        System.out.println();
        return dp[dp.length-1][dp[0].length-1];
    }

    static void printDiff(String str1,String str2,int n,int m,int[][] dp){
        if(n>0&&m>0&&str1.charAt(n-1)==str2.charAt(m-1)){
            printDiff(str1,str2,n-1,m-1,dp);
            System.out.print(" "+str1.charAt(n-1));
        }
        else if(n>0&&(m==0||dp[n-1][m]>=dp[n][m-1]))
        {
            printDiff(str1,str2,n-1,m,dp);
            System.out.print(" +"+str1.charAt(n-1));

        }
        else if(m>0&&(n==0||dp[n][m-1]>=dp[n-1][m]))
        {
            printDiff(str1,str2,n,m-1,dp);
            System.out.print(" -"+str1.charAt(n-1));

        }



    }



    public static void main(String[] agrs){

        System.out.println(LCS_length("ABCDFGHJQZ","ABCDEFGIJKRXYZ"));
    }
}