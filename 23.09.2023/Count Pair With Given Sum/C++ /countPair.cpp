class Solution {
public:
       int getPairsCount(int arr[], int n, int k) {
        int ans=0;
        unordered_map<int,int>mp;
        for(int i=0;i<n;i++){
            int req = k-arr[i];
            if(mp.find(req) != mp.end()){
                ans += mp[req];
            }
            mp[arr[i]]++;
        }
        return ans;
      }
}
