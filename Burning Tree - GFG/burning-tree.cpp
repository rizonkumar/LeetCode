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
   //RootToTarget->path from root to target node
   void RootToTarget(Node*root,int target,vector<Node*>&ans,vector<Node*>temp){
       if(root==NULL) return;
       temp.push_back(root);
       if(root->data==target){
           for(int i=0;i<temp.size();i++){
               ans.push_back(temp[i]);
           }
           return ;
       }
       RootToTarget(root->left,target,ans,temp);
       RootToTarget(root->right,target,ans,temp);
   }
   
   int height(Node*root,Node*block){
       if(root==NULL || root==block) return 0;
       int l=height(root->left,block);
       int r=height(root->right,block);
       return max(l,r)+1;
   }
   
   int minTime(Node* root, int target) 
   {
       vector<Node*>temp;
       vector<Node*>ans;
       RootToTarget(root,target,ans,temp);
       ans.push_back(NULL);
       reverse(ans.begin(),ans.end());
       //NULL 8 5 2 1
           // |  .
       int maxi=INT_MIN;
       for(int i=1;i<ans.size();i++){
           int h=height(ans[i],ans[i-1])-1;
           maxi=max(maxi,h+i-1);
       }
       return maxi;
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