import java.util.ArrayList;

public class RearrangeArrayBySigns {

    // Bruteforce
    public static int[] rearrangeArrayBrut(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            if(nums[i]<0) {
                neg.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }
        int idx = 0;
        int idx1= 0;
        int idx2= 0;
        while(idx1<pos.size() && idx2<neg.size()){
            if(idx % 2 == 0) {
                nums[idx] = pos.get(idx1++);
                
            } else {
                nums[idx] = neg.get(idx2++);
            }
            idx++;
        }
        
        
        nums[idx] = neg.get(idx2);
        
        return nums;
        
    }
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int posi=0;
        int negi=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res[posi]=nums[i];
                posi+=2;
            }
            else{
                res[negi]=nums[i];
                negi+=2;
            }
        }
        return res;
        
    }
    public static void main(String[] args) {
        int arr[] = {-1, 1};

        rearrangeArrayBrut(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
