class Solution {
    public boolean validMountainArray(int[] arr) {
        
        int n = arr.length;
        if(n < 3) return false;
        
        int i = 0;
        for(; i < n - 1; i++){
            if(arr[i] > arr[i+1]){
                i++;
                break;
            }
            else if(arr[i] == arr[i+1]){
                return false;
            }
        }
        if(i < 2) return false;
        for(; i < n; i++){
            if(arr[i-1] <= arr[i]){
                return false;
            }
        }
        
        return true;
    }
}