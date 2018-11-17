import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class longestCommonSubstring_3 {

    static String LCS_length(String str1,String str2){
        int[][] dp=new int[str1.length()+1][str2.length()+1];

        int max=0,index=str1.length();
        for (int i=1;i<dp.length;i++)
            for (int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(dp[i][j]>max) {
                        max = dp[i][j];
                        index=i;
                    }
                }
                else
                    dp[i][j]=0;
            }
        //System.out.println("Function 1");
        //System.out.println(Arrays.deepToString(dp));
        //System.out.println("index="+index+"   max="+max+"  string1="+str1+"   LCS="+(str1.substring(index-max,max)));
        return str1.substring(index-max,index);
    }
    public static void main(String[] agrs){

        System.out.println(LCS_length("DABCD","BABCA"));

    }
}