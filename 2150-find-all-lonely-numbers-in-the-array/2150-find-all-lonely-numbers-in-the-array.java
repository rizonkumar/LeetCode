//https://www.youtube.com/watch?v=XnISuMqoktw
class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) > 1 || map.containsKey(nums[i] + 1) || map.containsKey(nums[i] - 1))
                continue;
            
            ans.add(nums[i]);
        }
        
        return ans;
    }
}