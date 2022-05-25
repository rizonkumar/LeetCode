// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

class Solution
{
   public:    
      vector <int> commonElements (int A[], int B[], int C[], int n1, int n2, int n3)
       {
         vector<int> v;
           int i=0,j=0,k=0,c=0,z=INT_MAX;
           
           while(i<n1 && j<n2 && k<n3){
               if(A[i]==B[j] && A[i]==C[k]){
                 if(A[i]!=z){
                   z=A[i];
                    v.push_back(z);
                    c++;
                   }
                   
                   i++;j++;k++;
               }
               else if(A[i]<=B[j] && A[i]<=C[k])
                      i++;
                      
                      else if(B[j]<=C[k])
                      j++;
                      
                      else
                      k++;
                                     
                }
                
        if((c==0) && (A[n1-1]==B[n2-1] && A[n1-1]==C[n3-1]))
                     v.push_back(z);
            
                     
                     return v;
       }

};

// { Driver Code Starts.

int main ()
{
    int t; cin >> t;
    while (t--)
    {
        int n1, n2, n3; 
        cin >> n1 >> n2 >> n3;
        int A[n1];
        int B[n2];
        int C[n3];
        
        for (int i = 0; i < n1; i++) cin >> A[i];
        for (int i = 0; i < n2; i++) cin >> B[i];
        for (int i = 0; i < n3; i++) cin >> C[i];
        
        Solution ob;
        
        vector <int> res = ob.commonElements (A, B, C, n1, n2, n3);
        if (res.size () == 0) 
            cout << -1;
        for (int i = 0; i < res.size (); i++) 
            cout << res[i] << " "; 
        cout << endl;
    }
}  // } Driver Code Ends