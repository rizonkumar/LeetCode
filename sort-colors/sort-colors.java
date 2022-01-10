class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int middle = 0;
        int high = nums.length - 1;
        int temp;
        
        while(middle <= high){
            switch(nums[middle]){
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[middle];
                    nums[middle] = temp;
                    low++;
                    middle++;
                    break;
                }
                case 1: {
                    middle++;
                    break;
                }
                case 2:{
                    temp = nums[middle];
                    nums[middle] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}