class Solution {
    
    int resultStart;
    int resultLength;
    
    public String longestPalindrome(String s) {
        int strLength = s.length();
        if(strLength < 2){
            return s;
        }
        // loop to the string char by char and checking if each
        // indiviual char is a possible center of a possible 
        // palindrome substring and if it is no matter how long is 
        // the palindrome is keep track of length, keep track of starting
        // position and then end, and find the biggest one.
        
        for(int start = 0; start < strLength - 1; start++){
            checkPalindrome(s, start, start);   // n is odd
            checkPalindrome(s, start, start + 1); // if n is even because two mid point
        }
        return s.substring(resultStart, resultStart + resultLength);    
    }
    
    private void checkPalindrome(String str, int begin, int end){
        while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if(resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
    
}