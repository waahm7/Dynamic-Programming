import java.util.Arrays;

public class bitonicSubsequence_10 {


    static int LBS_length(int[] arr){
        int[] lis=new int[arr.length];
        Arrays.fill(lis,1);
        int[] dis=new int[arr.length];
        Arrays.fill(dis,1);
        for(int i=1;i<lis.length;i++)
            for(int j=0;j<i;j++)
                if(arr[i]>=arr[j])
                    lis[i]=Math.max(lis[i],lis[j]+1);

        for(int i=dis.length-2;i>=0;i--)
            for(int j=dis.length-1;j>i;j--)
                if(arr[i]>=arr[j])
                    dis[i]=Math.max(dis[i],dis[j]+1);
        int max = lis[0] + dis[0] - 1;
        for (int i = 1; i < dis.length; i++)
            if (lis[i] + dis[i] - 1 > max)
                max = lis[i] + dis[i] - 1;

        return max;

    }


    public static void main(String[] agrs){
        int[] A = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };

        System.out.println(LBS_length(A));
    }
}