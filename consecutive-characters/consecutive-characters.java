class Solution {
    public int maxPower(String s) {
        char prev = ' ';
        int maxi = 0;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == prev) cnt+= 1;
            else {
                cnt = 1;
            }
            maxi = Math.max(cnt, maxi);
            prev = c;
        }
        return maxi;
    }
}