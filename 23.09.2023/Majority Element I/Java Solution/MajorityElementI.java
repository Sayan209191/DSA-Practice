import java.util.HashMap;
import java.util.Map;

public class MajorityElementI {
    // Majority element --> n/2 times

    // Bruteforce
    public static int majorityEleBrut(int nums[], int n) {

        if (n == 1) {
            return nums[0];
        }
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }

            if(count > n/2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Better solution 

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        // for(int i=0; i<n; i++) {
        //     if(map.get(nums[i]) > n/2) {
        //         return nums[i];
        //     }
        // }

        for(Map.Entry<Integer,Integer> ele : map.entrySet()){
            if(ele.getValue() > n/2){
                return ele.getKey();
            }
        } 
        
        return -1;
    }
     
    // Optimal -> moore voting algorithm
    public static int mooreVoting(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ele = -1;
        for(int i=0; i<n; i++) {
            if(count == 0) {
                count =  1;
                ele = nums[i];
            } else if(nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityEleBrut(nums, nums.length));

        System.out.println(majorityElement(nums));

        System.out.println(mooreVoting(nums));
    }
}
