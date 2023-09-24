public class MaximumSubarraySum {
    // BruteForce Solution
    public static int sum(int arr[]) {
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum+= arr[k];
                }
                maxsum = Math.max(sum, maxsum);
            }
        }

        return maxsum;
    }

    // Better Solution

    public static int maxSubsum(int arr[]) {
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum+= arr[j];
                maxsum = Math.max(sum, maxsum);
            }
        }

        return maxsum;
    }

    // Optimal 

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            currSum=Math.max(nums[i],currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(sum(nums));

        System.out.println(maxSubsum(nums));

        System.out.println(maxSubArray(nums));
    }
}
