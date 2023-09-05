import java.util.HashMap;

public class ContainsDuplicateII {
    public static boolean containsDuplicate(int[] nums, int k) {
        // Bruteforce
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    if(Math.abs(j-i) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Optimal
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            if(map.containsKey(curr)) {
                if(Math.abs(i-map.get(curr)) <= k) {
                    return true;
                } else {
                    map.put(curr,i);
                }
            } else {
                map.put(curr, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] ={1,2,3,1,2,3};
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
