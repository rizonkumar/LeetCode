class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        int count = 0;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n;){
            count++;
            int maxi = nums[i] + k;
            while(i < n && nums[i] <= maxi){
                i++;
            } 
        }
        return count;
    }
};