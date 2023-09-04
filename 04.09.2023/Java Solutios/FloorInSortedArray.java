public class FloorInSortedArray {
    public static int findFloor(int nums[] , int k) {
        int n = nums.length;
        int floor = -1;
        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] <= k) {
                floor = mid;
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 8};

        System.err.println(findFloor(nums, 0));
    }
}
