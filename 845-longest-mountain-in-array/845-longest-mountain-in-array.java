class Solution {
    public int longestMountain(int[] A) {
        int res = 0;
        int n = A.length;
        
        for(int i = 1; i < n; i++){
            int count = 1;
            boolean flag = false;   // no decreasing sequence 
            
            // increasing sequence
            int j = i;
            
            while(j < n && A[j] > A[j-1]){
                j++;
                count++;
            }
            // decreasing sequence
            while(i!= j && j < n && A[j] < A[j-1]){
                j++;
                count++;
                flag = true;      // decreasing sequence 
            }
            // max of len
            // given in question array length should be greater than 3 so count > 2 
            if(i!=j && flag&& count > 2){
                res = Math.max(res,count);
                j--;
            }
            i = j;
        }
        return res;
    }
}