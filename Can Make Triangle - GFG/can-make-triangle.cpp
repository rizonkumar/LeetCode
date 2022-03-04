// { Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++
class Solution{
    public:
    vector<int> canMakeTriangle(vector<int> A, int N){
        vector<int> v(N-2);
        for(int i = 0; i < N-2; i++){
            int a = A[i];
            int b = A[i+1];
            int c = A[i+2];
            
            // Traingle Condition
            if(a+b>c && b+c>a && a+c>b){
                v[i] = 1;
            } else {
                v[i] = 0;
            }
        }
        return v;
    }
}; 

// { Driver Code Starts.
int main() 
{ 
    int t;cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        vector<int> A(N);
        for(int i=0;i<N;i++)
            cin>>A[i];
        Solution ob;
        auto ans = ob.canMakeTriangle(A, N);
        for(int i=0;i<ans.size();i++)
            cout << ans[i] << " ";
        cout << endl;
        
    }

    return 0; 
}   // } Driver Code Ends