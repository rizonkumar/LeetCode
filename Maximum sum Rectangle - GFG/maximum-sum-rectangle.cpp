// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
 int kadane(int arr[], int n)
   {
      int maxSum = INT_MIN;
      int currSum = 0;
      
      for(int i = 0; i < n; i++)
      {
           currSum += arr[i];
          
           if(currSum > maxSum)
              maxSum = currSum;
           
           if(currSum < 0)
              currSum = 0;
      }
     return maxSum;
   }
   
   int maximumSumRectangle(int R, int C, vector<vector<int>> M)
   {
       int res = INT_MIN;
       
       for(int i = 0; i < R; i++)
       {
           int temp[C] = { 0 };
           
           for(int row = i; row < R; row++)
           {
               for(int col = 0; col < C; col++)
               {
                   temp[col] += M[row][col];
               }  
               res = max(res, kadane(temp, C));
           }
       }
     return res;
   }
};


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M;
        cin >> N >> M;
        vector<vector<int>> v(N, vector<int>(M));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) cin >> v[i][j];
        Solution ob;
        cout << ob.maximumSumRectangle(N, M, v) << "\n";
    }
}  // } Driver Code Ends