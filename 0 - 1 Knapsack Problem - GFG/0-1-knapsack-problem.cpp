// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
public:
//Recursive + Memoization
   //Function to return max value that can be put in knapsack of capacity W.
   int knap(int W,int wt[],int val[],int n,vector<vector<int>>&dp){
       if(W==0 or n==0)return 0;
      if(dp[n][W]!=-1)return dp[n][W];
      if(W>=wt[n-1]){
          int inc=val[n-1]+knap(W-wt[n-1],wt,val,n-1,dp);
          int exc=knap(W,wt,val,n-1,dp);
          return dp[n][W]= max(inc,exc);
      }
      else if(W<wt[n-1]){
          int exc=knap(W,wt,val,n-1,dp);
          return dp[n][W]=exc;
      }
   }
   
   int knapSack(int W, int wt[], int val[], int n) 
   { 
      // Your code here
      vector<vector<int>>dp(n+1,vector<int>(W+1,-1));
      
      return knap(W,wt,val,n,dp);
      
   }
};

// { Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}  // } Driver Code Ends