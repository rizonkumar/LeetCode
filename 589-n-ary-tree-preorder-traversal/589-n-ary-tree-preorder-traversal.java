
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return result;
        preorderHelper(root);
        return result;
    }
    
    public void preorderHelper(Node node){
        if(node.children == null) return;
        result.add(node.val);
        for(Node child: node.children){
            preorderHelper(child);
        }
    }
}