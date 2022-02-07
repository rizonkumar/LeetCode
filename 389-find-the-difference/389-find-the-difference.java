class Solution {
    public char findTheDifference(String s, String t){
        s = s + t;
        char xor = s.charAt(0);
    
        for(int i=1; i<s.length(); i++)
        {
            xor = (char)(xor ^ s.charAt(i));
        }
    
    return xor;
    }
}