class Solution {
    public int findPairs(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                // the array element and  increament the frequence by 1
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // keep the frequene of current element as 1
                map.put(nums[i], 1);
            }
        }
        int count = 0;
        //create key set
        Set<Integer> set = map.keySet();
        for(int num: set){
            //first check
            if(k > 0 &&map.containsKey(num + k)){
                count++;
            }
            // second check
            if(k==0 && map.get(num) > 1){
                count++;
            }
        }
        return count;
    }
}