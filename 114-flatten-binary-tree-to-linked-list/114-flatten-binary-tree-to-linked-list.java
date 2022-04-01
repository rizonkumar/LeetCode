// 1st approach -> Recursive Approach
// T.C -> O(N)
// S.C -> O(N)
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }
}