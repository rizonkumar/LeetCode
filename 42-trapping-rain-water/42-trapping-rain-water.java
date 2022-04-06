class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int total_water = 0;
        int maxLeft = 0, maxRight = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                
                if(height[left] >= maxLeft) maxLeft = height[left];
                else total_water += maxLeft - height[left];
                
                left++;
            }
            else {
                if(height[right] >= maxRight) maxRight = height[right];
                else total_water += maxRight - height[right];
                
                right--;
            }
        }
        return total_water;
    }
}