class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        
        if(n == 0 || n == 1)
            return;
        
        // Two Pointer Approach
        int left = 0; 
        int right = 0;
        
        // for swap
        int temp;
        
        // Rearrangement
        while(right < n){
            // when ever right pointer see zero value it get incremented
            if(nums[right]==0)
                ++right;
            else {
                // when it see non-zero element it swap with left pointer value and then increment both right and left pointer
                
                //swap
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                ++left;
                ++right;
            }
        }
    }
}