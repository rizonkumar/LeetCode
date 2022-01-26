class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] Square = new int[nums.length];
        int smallerValueIdx = 0;
        int largerValueIdx = nums.length - 1;
        
        for(int idx = nums.length - 1; idx >= 0; idx--){
            int smallerValue = nums[smallerValueIdx];
            int largerValue = nums[largerValueIdx];
            
            if(Math.abs(smallerValue) > Math.abs(largerValue)){
                Square[idx] = smallerValue * smallerValue;
                smallerValueIdx++;
            } else {
                Square[idx] = largerValue * largerValue;
                largerValueIdx--;
            }
        }
        return Square;
    }
}