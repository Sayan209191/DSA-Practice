class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n,0);
        int pi = 0, ni = 1;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                ans[pi] = nums[i];
                pi += 2;
            }else{
                ans[ni] = nums[i];
                ni += 2;
            }
        }
        return ans;

        //Dividing the arr into positive and negative part and concatenate it
        // vector<int>pos ;
        // vector<int>neg;

        // for(int i=0;i<nums.size();i++){
        //     if(nums[i] > 0) pos.push_back(nums[i]);
        //     else neg.push_back(nums[i]);
        // }
        
        // int i = 0;
        // int j = 0;
        // nums.clear();
        // while(i<pos.size() && j<neg.size()){
        //     nums.push_back(pos[i]);i++;
        //     nums.push_back(neg[j]);j++;
        // }
        // return nums;
    }
};
