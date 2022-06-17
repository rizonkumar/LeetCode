/*
Greedily split the string, and with the counting
L +1
R -1

when the counter is reset to 0, we get one balanced string.
*/

class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L') {
                count++;
            } else {
                count--;
            }
            
            if(count == 0) ans++;
        }
        
        return ans;
    }
}