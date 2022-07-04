// { Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


 // } Driver Code Ends
class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
       long long int sum=0;
       int first_block=0;
       while(first_block<n-1)
       {
           while(first_block<n && arr[first_block]<=arr[first_block+1])
               first_block++;
           if(first_block==n)
               return sum;
           int last_block=first_block+1;
           while(last_block<n && arr[last_block]<arr[first_block])
               last_block++;
           if(last_block!=n)
           {
               for(int i=first_block+1;i<last_block;i++)
                   sum+=arr[first_block]-arr[i];
           }
           else
           {
               last_block=first_block+1;
               if(last_block==n)
                   return sum;
               for(int i=last_block;i<n;i++)
               {
                   if(arr[i]>arr[last_block])
                       last_block=i;
               }
               if(last_block!=first_block+1)
               {
                   for(int i=first_block+1;i<last_block;i++)
                       sum+=arr[last_block]-arr[i];
               }
           }
           first_block=last_block;
       }
       return sum;
   }
};

// { Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}  // } Driver Code Ends