import java.util.*;
// find all elements that appear more than ⌊ n/3 ⌋ times.
public class MajorityElementII {

    // Bruteforce -> using nested loops
    public static List<Integer> majorityEle(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 1) {
            ans.add(nums[0]);
        }
        for (int i = 0; i < n; i++) {
            //selected element is nums[i]:
            // Checking if nums[i] is not already a part of the answer:
            if (ans.size() == 0 || ans.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    // counting the frequency of nums[i]
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }

                // check if frquency is greater than n/3:
                if (count > (n / 3))
                    ans.add(nums[i]);
            }

            if (ans.size() == 2) break;
        }
        return ans;
    }
    // Better -> using hashmap -> TC & SC - O(N)
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); // element , count
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            // present -> count = count+1 , not present -> count=1
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> ele : map.entrySet()) { // tranumserse the map
            if(ele.getValue() > n/3) {  // check count is > n/3 or not
                list.add(ele.getKey());
            }
        } 
        return list;
    }
    // Optimal -> Moore numsoting Algo
    public static List<Integer> majorityElements(int nums[]) {
        List<Integer> res = new ArrayList<>();
        // initialize two counters 
        int count1 = 0; // track first majority count
        int count2 = 0; // track second majority count
        int ele1 = -1;  // first majority element
        int ele2 = -1;  // second majority element

        for(int i=0; i<nums.length; i++) {
             // check count1 zero or not and current element != second majority
            if(count1 == 0 && ele2 != nums[i]) { 
                ele1 = nums[i];
                count1=1;
            } else if(count2 == 0 && ele1 != nums[i]) {  // check count2 zero or not and current element != first majority
                count2=1;
                ele2 = nums[i];
            } else if(nums[i] == ele1) { // if first majority find increment count1
                count1++;
            } else if(nums[i] == ele2) { // if second majority find increment count2
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // for checking element 
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i<nums.length; i++) { 
            if(nums[i] == ele1) { // if curr = first majority then increment cnt1
                cnt1++;
            } else if(nums[i] == ele2) { //if curr = second majority then increment cnt2
                cnt2++;
            }
        }
        if(cnt1 > nums.length/3) { // check first majority present more than n/3 times or not
            res.add(ele1);
        } 
        if(cnt2 > nums.length/3) { // check second majority present more than n/3 times or not
            res.add(ele2);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 3};
        List<Integer> ans = majorityElements(nums);
        System.out.println(ans);
    }
}
