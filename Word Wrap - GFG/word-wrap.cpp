// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

int cache[505][2005];
int dp(int i, int rem, vector<int> &a, int &k) {
    int n = a.size();
    if(i>=n) {
        return 0;
    }
    int &ans = cache[i][rem+1];
    if(ans!=-1) return ans;
    
    if((a[i])>rem) {
        ans=(rem+1)*(rem+1) + dp(i+1,k-a[i]-1,a,k);
    }
    else {
        ans=min((rem+1)*(rem+1) + dp(i+1,k-a[i]-1,a,k) , dp(i+1,rem-a[i]-1,a,k));
    }
    
    return ans;
}
class Solution {
public:
    
    int solveWordWrap(vector<int>nums, int k) 
    { 
        memset(cache,-1,sizeof(cache));
        return dp(1,k-nums[0]-1,nums,k);
    } 
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, k;
        cin >> n;
        vector<int>nums(n);
        for (int i = 0; i < n; i++)cin >> nums[i];
        cin >> k;
        Solution obj;
        cout << obj.solveWordWrap(nums, k) << endl;
	}
	return 0;
}  // } Driver Code Ends