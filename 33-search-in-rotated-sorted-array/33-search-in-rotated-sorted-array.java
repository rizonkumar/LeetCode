class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(nums[mid] == target) return mid;
            
            // the left side is sorted
            if(nums[low] <= nums[mid]){
                // figure out if element lies on the left half or not
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // rigt half is sorted
            else {
                // figure out if element lies on the right half or not
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}