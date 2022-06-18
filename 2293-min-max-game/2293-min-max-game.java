// Discussion Solution
class Solution {
    public int minMaxGame(int[] a) {
        for(int n= a.length; n>1 ; n-=(n/2)){
            for(int i=0;i<n/2;i++) 
                a[i]= (i%2)==1? Math.max(a[2 * i], a[2 * i + 1]) : Math.min(a[2 * i], a[2 * i + 1]);   
        }
        return a[0];
    }
}