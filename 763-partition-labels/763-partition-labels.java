class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        //step 1. filling of impact of character
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i); //if its available, we update it  else it create new  one and add it.
        }
        
        // step 2. making of result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if(max == i) { // at this moment we make partition 
                res.add(max - prev);
                prev = max;     // update the prev
            }
        }
    return res;
    }
}