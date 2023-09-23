class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majorityElement(vector<int>& nums) {
        int count = 0;
        int MajorEle;
        for(int i=0;i<nums.size();i++){
            if(count == 0){
                MajorEle = nums[i];
                count = 1;
            }
            else if(nums[i] == MajorEle) count++;
            else count--;
        }
        return MajorEle;  
        // As it is given that always exits a majority ele
        // So we don't have to recheck by counting its freq

        //--------------------------------
        // int n = nums.size();
        // unordered_map<int,int>mp;
        // for(int i=0;i<n;i++){
        //     mp[nums[i]]++;
        //     if(mp[nums[i]] > n/2){
        //         return nums[i];
        //     }
        // }
        // return 0;
    
    }
};
