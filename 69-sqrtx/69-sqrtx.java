class Solution {
    public int mySqrt(int x) {
        long y = 0;
        while(y * y <= x){
            y++;
        }
        return (int) y - 1;
    }
}