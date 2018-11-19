import java.util.HashMap;

public class longestAdjacentNumberSequence_16 {

    static StringBuffer str;
    static HashMap<String,String> map;
    static void adjacentSequenceLength(int[][] arr,int n,int m){
        if (n<0||m<0 ||n>=arr.length||m>=arr[0].length)
            return ;
        String key=n+":"+m;
        if(map.containsKey(key))
            return;
       /* includes diagonals
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if (i<0||j<0 ||i>=arr.length||j>=arr[0].length)
                    continue;
                if(arr[n][m]==arr[i][j]-1){
                    str.append(arr[i][j]+" ");
                    adjacentSequenceLength(arr,i,j);
                    break;
                }
            }
        }
        */
       if(n>0&&arr[n-1][m]==arr[n][m]+1){
           str.append(arr[n-1][m]+" ");
           adjacentSequenceLength(arr,n-1,m);
       }
       else if(m>0&&arr[n][m-1]==arr[n][m]+1) {
            str.append(arr[n][m-1] + " ");
            adjacentSequenceLength(arr, n, m-1);
       }
       else if(n<arr.length-1&&arr[n+1][m]==arr[n][m]+1){
            str.append(arr[n+1][m]+" ");
            adjacentSequenceLength(arr,n+1,m);
        }
        else if(m<arr[0].length-1&&arr[n][m+1]==arr[n][m]+1) {
            str.append(arr[n][m+1] + " ");
            adjacentSequenceLength(arr, n, m+1);
        }

        map.put(key,str.toString());

    }



    public static void main(String[] agrs){
        int arr[][] ={{ 10, 13, 14, 21, 23 },
                    { 11,  9, 22,  2,  3 },
                    { 12,  8,  1,  5,  4 },
                    { 15, 24,  7,  6, 20 },
                    { 16, 17, 18, 19, 25 }};

        str=new StringBuffer(arr.length*arr[0].length);
        map=new HashMap<>();
        String result="";
        long max=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                str.append(arr[i][j]+" ");
                adjacentSequenceLength(arr,i,j);
                long size = str.chars().filter(ch->ch==' ').count();
                if(size>max){
                    result=str.toString();
                    max=size;
                }
                str.setLength(0);
            }
        }
        System.out.println(result);
    }
}
