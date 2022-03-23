class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target)
            return startValue - target;
        
        // as we are trying to move backward we do divide and addition
        if(target%2 == 0){
            return 1 + brokenCalc(startValue, target/2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }
}