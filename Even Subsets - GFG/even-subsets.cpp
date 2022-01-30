// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

/*Function to count subset with even sum
* arr : array input
* N : size of array
*/
class Solution{
  public:
    int countSumSubsets(int arr[], int N)    {
        int ans = 0, sum = 0;
        int powerSetSize = pow(2, N);
        for(int i = 0; i < powerSetSize; i++){
            for(int j = 0; j < N ; j++){
                if(i &(1<<j)){
                    sum += arr[j];
                }
            }
            if(sum %2 == 0){
                ans++;
            }
            sum = 0;    // we have to start from again 
        }
        return ans - 1; // empty no is not even so -1
    }
};

// { Driver Code Starts.

// Driver code to test columnWithMaxZeros function
int main() {
	
	int testcase;
	
	cin >> testcase;
	
	while(testcase--){
	    int N;
	    cin >> N;
	    
	    int arr[N];
	    
	    // Taking elements input into the matrix
	    for(int i = 0;i<N;i++){
	            cin >> arr[i];
	        }
	    Solution obj;
	    cout << obj.countSumSubsets(arr, N) << endl;
	}
	
	return 0;
}  // } Driver Code Ends