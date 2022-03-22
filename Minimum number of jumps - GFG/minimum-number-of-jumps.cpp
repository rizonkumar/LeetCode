// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// Function to return minimum number of jumps to end of array
class Solution
{
 public:
   int minJumps(int arr[], int n)
   {
       // Your code here
       int count=1;
       int jmp=arr[0];
       int maxi=arr[0];
       if(jmp==0)
       {
           if (n==1)
             return 0;
           return -1;
       }
       for(int i=1; i<n-1;i++)
       {
           maxi--;
           maxi=max(maxi, arr[i]);
           jmp--;

           if(jmp==0)
           {
               jmp=maxi;
               count++;
           }
           if (jmp<=0)
             return -1;

       }
       return count;
   }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,i,j;
        cin>>n;
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        Solution obj;
        cout<<obj.minJumps(arr, n)<<endl;
    }
    return 0;
}
  // } Driver Code Ends