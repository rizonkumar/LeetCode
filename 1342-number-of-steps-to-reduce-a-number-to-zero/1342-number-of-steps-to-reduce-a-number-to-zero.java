class Solution {
    public int numberOfSteps(int num) {
        
        // base case 
        if(num == 0)
        {
            return 0;
        }
        
        // recursive case
        
        return 1 + numberOfSteps(num % 2 == 0 ? num / 2 : num - 1);
    }
}