class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        flip(nums, 0, n-1);
        flip(nums, 0, k-1);
        flip(nums, k, n - 1);
    }
    
    public void flip(int[] arr, int s, int e){
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}