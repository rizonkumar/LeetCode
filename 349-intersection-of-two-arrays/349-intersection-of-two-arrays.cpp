class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int n = nums1.size();
        int m = nums2.size();
        
        set<int>s;  // as you need only unqiue result
        int i = 0, j = 0;   // two pointer
        while(i<n && j<m){
            if(nums1[i] > nums2[j]) j++; //if the element of i greater than j
            else if(nums1[i] < nums2[j]) i++;
            else{
                //if both are equal you push that into set
                s.insert(nums1[i]);
                i++;
                j++;
            }
        }
        // as you need to return it as vector, you iterate over it and print them
        vector<int>ans;
        for(auto i: s) ans.push_back(i);
        return ans;
    }
};