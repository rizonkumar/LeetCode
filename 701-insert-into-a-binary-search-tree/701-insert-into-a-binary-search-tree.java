class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        // create copy of root because at the end u need to return root itself
        TreeNode cur = root;
        while(true){
            //  right side
            if(cur.val <= val){
                if(cur.right != null) cur = cur.right;
                else {
                    // if its null
                    cur.right = new TreeNode(val);
                    break;
                }
            } // left side
            else {
                if(cur.left != null) cur = cur.left;
                else {
                    // if its null
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    
}