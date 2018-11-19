import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class minimumSumPartitionProblem_21 {

    public static int minPartition(int[] S, int n, int S1, int S2, Map<String, Integer> lookup) {
        if (n < 0)
            return Math.abs(S1 - S2);

        String key = n + "|" + S1;

        if (!lookup.containsKey(key)) {
            int inc = minPartition(S, n - 1, S1 + S[n], S2, lookup);
            int exc = minPartition(S, n - 1, S1, S2 + S[n], lookup);
            lookup.put(key, Integer.min(inc, exc));
        }
        return lookup.get(key);
    }

    public static void main(String[] agrs){
        int[] S = { 10, 20, 15, 5, 25 };

        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The minimum difference is " + minPartition(S, S.length - 1, 0, 0, lookup));
    }
}
