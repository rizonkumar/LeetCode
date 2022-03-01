class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2]; // as i have to return index
        int left = 0;
        int right = numbers.length - 1;
        
        while(left < right){
            int current_sum = numbers[left] + numbers[right];
            if(current_sum == target){
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if(current_sum > target){
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }
}