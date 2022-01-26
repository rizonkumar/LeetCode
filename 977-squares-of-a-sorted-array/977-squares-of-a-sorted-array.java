class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] Square = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            Square[i] = val * val;
        }
        Arrays.sort(Square);
        return Square;
    }
}