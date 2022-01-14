class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            
            // handling subtractive use case 
            // when there is character where lower character in front of higher character
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))){
                //so if you what you get over here is greater than what you got before in that case what you 
                // added before was mistake so you undo that and then  do this - previous one
                // this is what i am doing in this line 
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                //addtive use case
            result += map.get(s.charAt(i));
                
            }
        }
        return result;
    }
}