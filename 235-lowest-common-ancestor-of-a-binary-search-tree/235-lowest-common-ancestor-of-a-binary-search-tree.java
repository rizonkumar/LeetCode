/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        int curr = root.val;
        // both of them in right side
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // both of them in left side
        if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // if thts not the case then its the first point or last point of intersection
        return root;
    }
}