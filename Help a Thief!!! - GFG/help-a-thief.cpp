// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
  bool static cmp(pair<int,int>p,pair<int,int>p1){
      return p.second>p1.second;
  }
    int maxCoins(int A[], int B[], int T, int N) {
        if(T==0)return 0;
        vector<pair<int,int>>v;
        int ans=0;
        for(int i=0;i<N;i++){
            pair<int,int>p;
            p.first=A[i];
            p.second=B[i];
           v.push_back(p); 
        }
        sort(v.begin(),v.end(),cmp);
        
        for(int i=0;i<N;i++){
            if(T==0)break;
            int a=v[i].first;
            int b=v[i].second;
            if(a<=T){
                T=T-a;
                ans+=a*b;
            }
            else{
               ans+=T*b;
               T=0;
            }
        }
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int T,N;
        cin>>T>>N;
        
        int A[N], B[N];
        
        for(int i=0; i<N; i++)
            cin>>A[i];
        for(int i=0; i<N; i++)
            cin>>B[i];

        Solution ob;
        cout << ob.maxCoins(A,B,T,N) << endl;
    }
    return 0;
}  // } Driver Code Ends