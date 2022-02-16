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
   
    private void dfs(TreeNode node, List<Integer> inorder){
        if(node == null) return;
        
        // InOrder -> Left Root Right
        dfs(node.left, inorder);
        inorder.add(node.val);
        dfs(node.right, inorder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        dfs(root, inorder);
        return inorder; 
    }
    
    */
    
    // Iterative
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else{ // if it is null whtever is at top is our inorder{
                 if(stack.isEmpty()){
                     break;
                 }
            node = stack.pop();
            inorder.add(node.val);
            node = node.right;
            }
        }
    return inorder;
    }
}