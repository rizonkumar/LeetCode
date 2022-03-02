class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int tIndx = 0;
        int sIndx = 0;
        
        while(tIndx < t.length() && sIndx < s.length()){
            if(s.charAt(sIndx) == t.charAt(tIndx)){
                sIndx++;
            }
            tIndx++;
        }
        return sIndx == s.length();
    }
}