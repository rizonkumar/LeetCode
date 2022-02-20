class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root == NULL) return result;
        
        queue<TreeNode*> nodesQueue;
        nodesQueue.push(root);
        bool leftToRight = true;    // true means L to R, false R to L
        
        while(!nodesQueue.empty()){
            //taking all the node of that levels 
            int size = nodesQueue.size();
            vector<int> row(size);
            for(int i=0; i<size; i++){
                TreeNode* node = nodesQueue.front();
                nodesQueue.pop();
                
                //find position to fill nodes values
                int index = (leftToRight) ? i : (size - 1 - i);
                row[index] = node->val;
                if(node->left){
                    nodesQueue.push(node->left);
                }
                if(node->right){
                    nodesQueue.push(node->right);
                }
            }
            // after this level (switch over the flag)
            leftToRight = !leftToRight;
            result.push_back(row);
        }
        return result;
    }
};