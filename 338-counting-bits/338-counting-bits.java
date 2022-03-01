class Solution {
    public int[] countBits(int n) {
        // create one ans array,
        // & our array size is n + 1 because we have to cover 0 as well
        int[] ans = new int[n+1];
        // base condition
        if(n == 0 ) return ans;
        
        // run a loop to store all the values
        for(int i=1;i<n+1;i++) {
            if(i%2 == 0) { 
            // number is even
                ans[i] = ans[i/2];
            }
            else { 
            // is odd
                ans[i] = ans[i/2] + 1;
            }
        }
        return ans;
    }
}