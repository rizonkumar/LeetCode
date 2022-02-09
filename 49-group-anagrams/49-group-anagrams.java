class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        
        for(String str: strs){
            // find the frequences
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }
            
            if(bmap.containsKey(fmap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(fmap, list);
            } else {
                ArrayList<String> list = bmap.get(fmap);
                list.add(str);
            }
        }
        
        return new ArrayList<List<String>>(bmap.values());
    }
}