/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /*
    // Recursion
    private void dfs(TreeNode node, List<Integer> preorder){
        if(node == null)
            return;
        
        //PreOrder => Root Left Right
        preorder.add(node.val);
        dfs(node.left, preorder);
        dfs(node.right, preorder);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        dfs(root, preorder);
        return preorder;
    }
    */
    
    // Iterative
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> preorder = new ArrayList<Integer>();
        if(root == null) return preorder;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            preorder.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorder;
    }
}