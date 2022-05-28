 // since the n numbers are from [0, n], we can just add all the numbers from [0, n] together and minus the sum of the n-1 numbers in array.

class Solution {
    public static int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }
}