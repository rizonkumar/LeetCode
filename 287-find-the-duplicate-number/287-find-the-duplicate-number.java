class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast); //bound to meet after they meet we will
                            // and then we keep fast pointer to position 0
                            //after that we move fast & slow by 1 till they
                            // meet and thats the answer.
        
        slow = nums[0]; // find the entrance of the cycle
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}