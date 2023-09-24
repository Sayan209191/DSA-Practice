import java.util.HashMap;

public class CountPairsWithGivenSum {
    // Bruteforce -> use nested loops
    public static int pairSum(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            int rem = k - arr[i]; // remaining
            for(int j = i+1; j < n; j++) {
                if(rem == arr[j]) { // if remaining present add 1 to ans 
                    count++; 
                }
            }
        }
        return count;
    }
    // Optimal -> TC & SC -> O(N)
    public static  int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();  // element , count
        int count = 0;
        for(int i=0; i<n; i++) {
            int rem = k-arr[i]; // remaining
            // if present then add to ans how many time its exist
            if(map.containsKey(rem)) { 
                count+= map.get(rem);
            } 
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int N = 4, K = 6;
        int arr[] = {1, 5, 7, 1};

        System.out.println(getPairsCount(arr, N, K));
    }
}
