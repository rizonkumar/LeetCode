
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            // if the root value is less than val then move left else move right
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}