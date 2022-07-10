// Approach - 2 (using swap)
class Solution {
private:
    void rPermute(int ind, vector<int> &nums, vector<vector<int>> &ans){
        // base case
        if(ind == nums.size()){
            ans.push_back(nums);
            return;
        }
        for(int i = ind; i < nums.size(); i++){
            swap(nums[ind], nums[i]);
            rPermute(ind + 1, nums, ans);
            swap(nums[ind], nums[i]);
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        rPermute(0, nums, ans);
        return ans;
    }
};