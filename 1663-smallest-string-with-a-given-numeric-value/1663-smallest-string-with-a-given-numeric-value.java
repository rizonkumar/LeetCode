class Solution {
    public String getSmallestString(int n, int k) {
        char[] c = new char[n];
        
        for(int i = n-1; i>=0; i--){
            int val = Math.min(26,k - i);
            c[i] = (char)('a'+val-1); //using (char) to convert ASCII to respective character
            k=k-val;
        }
        return new String(c);
    }
}