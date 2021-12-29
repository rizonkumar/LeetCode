// normal dp
class Solution {

private:
    int func(int ind, vector<int> &nums,vector <int> &dp){
        if(ind >= nums.size())
            return 0;
        
        if(dp[ind] != -1) return dp[ind];
        // steal
        int steal = nums[ind] + func(ind + 2, nums, dp);
        // not steal
        int notSteal = func(ind + 1, nums, dp);
        
        return dp[ind] = max(steal, notSteal);
    }
    
public:
    int rob(vector<int>& nums) {
        vector<int>dp(nums.size(), -1);
        return func(0, nums, dp);
    }
};