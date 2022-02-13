class Solution {
public:
    void genSub(int i,vector<int>& sub,vector<int>& nums,vector<vector<int>>& ans)
    {
        if(i==nums.size())
        {
            ans.push_back(sub);
            return;
        }
        else
        {
            sub.push_back(nums[i]);         //including
            genSub(i+1,sub,nums,ans);       // backtracking
            sub.pop_back(); 
            genSub(i+1,sub,nums,ans);
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) 
    {
        vector<vector<int>> ans;
        vector<int> sub;
        genSub(0,sub,nums,ans);
        return ans;
    }
};