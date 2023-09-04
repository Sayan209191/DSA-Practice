public class MaximumConsecutiveOnes {
    public static int maximumOnes(int arr[], int k) {
        int n = arr.length;
        int st = 0;
        int end = 0;
        int zero = 0;
        int maxi = 0;
        
        while(st < n) {
            if(arr[st] == 0) {
                zero++;
            }
            while(end < n && zero > k ) {
                if(arr[end] == 0) {
                    zero --;
                }
                end++;
            }
            
            maxi = Math.max(maxi, st-end+1);
            st++;

        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};

        System.out.println(maximumOnes(nums, 2));
    }
}
