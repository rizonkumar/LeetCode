class Solution {
    public int maxPathSum(TreeNode root) {
        // as in java taking it as array because we know that 
        // variable and cannot pass it as reference so declared
        // with size 1 and stored the maxvalue in 0th index
        // in C++ direct int maxi = INT_MIN;
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    
    private int maxPathDown(TreeNode node, int maxValue[]){
        if(node == null) return 0;
        
        //if there is -ve then max will be 0
        int leftSum = Math.max(0, maxPathDown(node.left, maxValue));
        int rightSum = Math.max(0, maxPathDown(node.right, maxValue));
        
        maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}