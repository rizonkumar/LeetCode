// { Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++
class Solution
{
public:
 long long countStrings(string s){
        long long n=s.length()-1;
        long long ans=n*(n+1)/2ll;
        vector<long long> mp(26,0);
        long long curr=ans;
        
        for(auto i:s) mp[i-'a']++;
        for(int i=0;i<26;i++){
            long long cnt=mp[i]-1;
            ans-=(cnt*(cnt+1))/2ll;
        }
        return ans==curr?ans:ans+1;
    }
};


// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin>>S;
        Solution ob;
        long long ans = ob.countStrings(S);
        cout<<ans<<endl;
    }
    return 0;
}   // } Driver Code Ends