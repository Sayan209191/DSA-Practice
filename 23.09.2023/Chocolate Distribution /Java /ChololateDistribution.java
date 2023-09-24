import java.util.ArrayList;
import java.util.Collections;

public class ChololateDistribution {
    // Solve using gready algorithm  -> O(nlogn)
    public static long findMinDiff (ArrayList<Integer> a, int n, int m){
        if(m > n) {
            return -1;
        }
        Collections.sort(a);
        int minChooclate = Integer.MAX_VALUE; // minimum value
        for (int i=0; i<=n-m; i++) {
            int currDiff = a.get(i+m-1) - a.get(i); // mth student - 1st student
            minChooclate = Math.min(minChooclate, currDiff);
        }
        return (long)minChooclate;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // N = 8, M = 5
        // A = {3, 4, 1, 9, 56, 7, 9, 12}

        arr.add(3);
        arr.add(4);
        arr.add(1);
        arr.add(9);
        arr.add(56);
        arr.add(7);
        arr.add(9);
        arr.add(12);

        int n = arr.size();
        int m = 5;

        System.out.println(findMinDiff(arr, n, m));
    }
}
