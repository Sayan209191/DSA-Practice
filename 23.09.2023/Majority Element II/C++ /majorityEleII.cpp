class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        int cnt1 = 0, cnt2 = 0;
        int Ele1 = INT_MIN;
        int Ele2 = INT_MIN;
        // Moore's Voting Algo
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && nums[i] != Ele2){
                Ele1 = nums[i]; cnt1 = 1;
            }
            else if(cnt2 == 0 && nums[i] != Ele1){
                Ele2 = nums[i]; cnt2 = 1;
            }
            else if(nums[i] == Ele1) cnt1++;
            else if(nums[i] == Ele2) cnt2++;
            else{
                cnt1--; cnt2--;
            }
        }
        // Checking Part
        vector<int> ans;
        cnt1 = 0, cnt2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == Ele1) cnt1++;
            if(nums[i] == Ele2) cnt2++;
        }
        int mini = int(n/3)+1;
        if(cnt1 >= mini) ans.push_back(Ele1);
        if(cnt2 >= mini) ans.push_back(Ele2);

        return ans;


//---------------------Using HashMap-------------------------
        // int n = nums.size();
        // map<int, int>m;
        // vector<int>ans;
        // for(int i=0;i<n;i++){
        //     m[nums[i]]++;
        //     if(m[nums[i]]== (n/3)+1){
        //         ans.push_back(nums[i]);
        //     }
        //     if(ans.size()==2) break;
        // }
        // return ans;
    }
};
