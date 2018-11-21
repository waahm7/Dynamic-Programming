import java.util.Arrays;

public class nDigitBinaryStringWithoutConsectiveOnes_23 {

    public static int nDigitBinaryStrings(int n,int lastDigit) {
        if(n==0)
            return 0;
        if(n==1){
            if(lastDigit==1)
                return 1;
            else
                return 2;
        }
        if(lastDigit==0)
            return nDigitBinaryStrings(n-1,0)+nDigitBinaryStrings(n-1,1);
        return nDigitBinaryStrings(n-1,0);
    }

    public static void main(String[] args) {
        int n=5;
        System.out.print(nDigitBinaryStrings(n,0));
    }
}
