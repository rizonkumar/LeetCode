class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        
        int count = 0;
        //iterate
        for(int i: map.keySet()){
            if(map.containsKey(i) && map.containsKey(k-i)){
                if(i!=k-i){
                    count+=Math.min(map.get(i), map.get(k-i));
                    map.put(i,0);
                    map.put(k-i,0);
                } else {
                    count += Math.floor(map.get(i)/2);
                    map.put(i,0);
                }
            }
        }
        return count;
    }
}