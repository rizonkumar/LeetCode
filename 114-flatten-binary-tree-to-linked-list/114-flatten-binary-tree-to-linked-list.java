// TC - O(N) 
// SC - O(N) 
// Iterative 
class Solution {

    public void flatten(TreeNode root) {
        if(root == null) return; 
        
        Deque<TreeNode> st = new ArrayDeque<>(); 
        st.push(root); 
        while(!st.isEmpty()) {
            TreeNode cur = st.peek();
            st.pop();
            
            if(cur.right != null) {
                st.push(cur.right); 
            }
            if(cur.left != null) {
                st.push(cur.left); 
            }
            if(!st.isEmpty()) {
                cur.right = st.peek(); 
            }
            cur.left = null;
        }
        
    }
}