import java.util.Arrays;

public class longestPalindromeSequence_4 {

    static int longestPalindrome(String str1){
        if(str1.length()<=1)
            return 1;
        if(str1.charAt(0)==str1.charAt(str1.length()-1))
           return 2+longestPalindrome(str1.substring(1,str1.length()-1));
        int n1=Math.max(longestPalindrome(str1.substring(1)),longestPalindrome(str1.substring(str1.length()-1)));
        return n1;
    }

    public static void main(String[] agrs){

        System.out.println(longestPalindrome("ABBDCACB"));
    }
}