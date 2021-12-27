class Solution {
    
    private boolean checkPalindrome(char[] s){
        int l = 0, r = s.length - 1;
        while(l <= r){
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String it: words){
            if(checkPalindrome(it.toCharArray())) return it;
        }
        return "";
    }
};