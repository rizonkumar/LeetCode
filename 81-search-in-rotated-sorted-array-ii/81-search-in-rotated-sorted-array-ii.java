class Solution {
    public boolean search(int[] nums, int target) {
    if (null == nums || 0 == nums.length)
      return false;
    
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      // to avoid duplicates
      while (low < high && nums[low] == nums[low + 1])
        ++low;
      while (low < high && nums[high] == nums[high - 1])
        --high;
      
      // the code below is exactly the same with Problem 33.
      int mid = low + (high - low) / 2;
      if (nums[mid] == target)
        return true;
      
      // the left side is sorted
      if (nums[low] <= nums[mid]) {
          // figure out if element lies on the left half or not
        if (target >= nums[low] && target < nums[mid])
          high = mid - 1;
        else
          low = mid + 1;
      } 
        // rigt half is sorted
        else {
        // figure out if element lies on the right half or not
        if (target > nums[mid] && target <= nums[high])
          low = mid + 1;
        else
          high = mid - 1;
      }
    }
    
    return false;
  }
}