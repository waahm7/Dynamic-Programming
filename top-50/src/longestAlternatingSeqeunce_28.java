import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class longestAlternatingSeqeunce_28 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static HashMap<String,Integer> map;
    static int count;
    static int LIS_length(int[] arr){
        int[][] dp=new int[arr.length][2];
        for(int i=0;i<arr.length;i++)
            dp[i][0]=dp[i][1]=1;

        int res=-1;
        for (int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    dp[i][0]=Math.max(dp[i][0],dp[j][1]+1);
                    }
                if(arr[j]>arr[i]){
                    dp[i][1]=Math.max(dp[i][1],dp[j][0]+1);
                }

            }
            if(res<Math.max(dp[i][0],dp[i][1]))
                res=Math.max(dp[i][0],dp[i][1]);
        }
        return res;
    }

    public static void main(String[] agrs){
//        FastReader fr=new FastReader();
//        int arr[] = new int[fr.nextInt()];
//        for(int i=0;i<arr.length;i++)
//            arr[i]=fr.nextInt();
        map=new HashMap<>();
        int arr[] = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };

        System.out.println(LIS_length(arr));
    }
}