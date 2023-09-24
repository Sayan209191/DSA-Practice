class Solution {
public :
    long long findMinDiff(vector<long long> a, long long n, long long m){
        sort(a.begin(), a.end());
        int i=0,j=m-1;
        long long ans=INT_MAX;
        while(j<n){
            ans = min(ans, a[j]-a[i]);
            i++;j++;
        }
        return ans;
}
