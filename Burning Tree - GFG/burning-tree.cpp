// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};


Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    void burnTheTree(Node *root,int maxT,stack<Node *>&st,int &ans,Node* blocker){
        if(root==NULL || root==blocker) return;
        
        if(root->left!=NULL){
            burnTheTree(root->left,maxT+1,st,ans,blocker);
        }
        if(root->right!=NULL){
            burnTheTree(root->right,maxT+1,st,ans,blocker);
        }
        if(st.top() == root){
            st.pop();
            if(!st.empty()) burnTheTree(st.top(),maxT+1,st,ans,root);
        }
        ans = max(maxT,ans);
    }
    void rootToNodePath(Node *root,int target,vector<Node*> &v,stack<Node*>&s){
        if(root == NULL) return;
        v.push_back(root);
        if(root->data==target)
        {
            for(int i =0 ;i<v.size() ;i++) s.push(v[i]);
            return;
        }
        rootToNodePath(root->left,target,v,s);
        rootToNodePath(root->right,target,v,s);
        v.pop_back();
    }
    int minTime(Node* root, int target) 
    {
        // Your code goes here
        int ans = 0;
        stack<Node*> st;
        vector<Node*> v;
        rootToNodePath(root,target,v,st);
        Node* blocker = NULL;
        burnTheTree(st.top(),0,st,ans,blocker);
        return ans;
    }
};

// { Driver Code Starts.

int main() 
{
    int tc;
    scanf("%d ", &tc);
    while (tc--) 
    {    
        string treeString;
        getline(cin, treeString);
        // cout<<treeString<<"\n";
        int target;
        cin>>target;
        // cout<<target<<"\n";

        Node *root = buildTree(treeString);
        Solution obj;
        cout<<obj.minTime(root, target)<<"\n"; 

        cin.ignore();

    }


    return 0;
}
  // } Driver Code Ends