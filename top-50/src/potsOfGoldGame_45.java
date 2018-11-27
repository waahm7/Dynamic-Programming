import java.util.HashMap;

public class potsOfGoldGame_45 {
    static HashMap<String,Integer> map;
    public static int maxCoinsByPlayer(int[] arr,int i,int j) {
        if(i>j)
            return 0;
        //choose from pot 1
        String key=i+":"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int val= arr[i]+Math.min(maxCoinsByPlayer(arr,i+2,j),maxCoinsByPlayer(arr,i+1,j-1));
        int val2= arr[j]+Math.min(maxCoinsByPlayer(arr,i,j-2),maxCoinsByPlayer(arr,i+1,j-1));
        int result=Math.max(val,val2);
        map.put(key,result);
        return result;
    }

    public static void main(String[] args) {
        int[] coin = { 4, 6, 2, 3,5,3,2,1,4,6,4,2,1,3,5,6,3,2,3 };
        map=new HashMap<>();
        System.out.print(maxCoinsByPlayer(coin,0,coin.length-1));
    }
}
