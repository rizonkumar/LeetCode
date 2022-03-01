class Solution {
    public int[] countBits(int n) {
    // create one result array,
    // & our array size is n + 1 because we have to cover 0 as well
        int[] R = new int[n+1];
        if(n==0) return R;
        
        // run a loop to store all the values
        for(int i=1;i<n+1;i++) {
            if(i%2 == 0) { // number is even
                R[i] = R[i/2];
            }
            else { // is odd
                R[i] = R[i/2] + 1;
            }
        }
        return R;
    }
}