import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class printAllLCS_2 {

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

        System.out.println(LCS(str1,str2,str1.length(),str2.length(),dp));
        return dp[dp.length-1][dp[0].length-1];
    }

    static List<String> LCS(String str1, String str2, int m, int n, int[][] dp){
        if(m==0||n==0)
            return new ArrayList<>(Collections.nCopies(1,""));
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            List<String> lcs=LCS(str1,str2,m-1,n-1,dp);
            for (int i=0;i<lcs.size();i++)
                lcs.set(i,lcs.get(i)+str2.charAt(n-1));
            return lcs;
        }
        if(dp[m-1][n]>dp[m][n-1])
            return LCS(str1,str2,m-1,n,dp);
        if(dp[m-1][n]<dp[m][n-1])
            return LCS(str1,str2,m,n-1,dp);

        List<String> top=LCS(str1,str2,m-1,n,dp);
        List<String> bottom=LCS(str1,str2,m,n-1,dp);
        top.addAll(bottom);
        return top;

    }

    public static void main(String[] agrs){

        System.out.println(LCS_length("ABCBDAB","BDCABA"));
    }
}