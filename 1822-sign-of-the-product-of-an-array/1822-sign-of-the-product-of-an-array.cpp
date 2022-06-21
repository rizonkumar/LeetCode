// Better Approach
/*
is it neccessary to calculate the product?
    we can keep track of the postive  and negative
    
if we count nos of negative if the count come even then +ve
else -ve 
*/

class Solution {
public:
    int arraySign(vector<int>& nums) {
        
        int cnt = 0;
        
        for(auto i: nums){
            if(i == 0) return 0;
            if(i < 0) cnt++;
        }
        return cnt % 2 == 0 ? 1 : -1;
    }
};