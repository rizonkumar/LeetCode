// { Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

#define inf -100000000
#define mod 1000000007
class Solution {
    int solve1(int i , int j  , int n , int m , vector<vector<int>>& matrix ,vector<vector<int>>&dp1 ){
        if(i == n - 1 && j == m - 1)
        return 1;
        if(i >= n || j >= m)
        return 0;
        if(dp1[i][j] != -1)
        return dp1[i][j];
        if(matrix[i][j] == 1)
        return dp1[i][j] = solve1(i , j + 1 , n , m , matrix ,dp1);
        else if(matrix[i][j] == 2)
        return dp1[i][j] = solve1(i + 1, j , n , m , matrix ,dp1);
        else
        return dp1[i][j] = (solve1(i , j + 1 , n , m , matrix , dp1) + solve1(i + 1 , j , n , m , matrix , dp1)) % mod;
        
    }
    int solve2(int i , int j , int n , int m , vector<vector<int>>& matrix , vector<vector<int>>&dp2){
        if(i == n -1 && j == m - 1){
            return matrix[i][j];
        }
        if(i >= n || j >= m)
        return inf;
        if(dp2[i][j] != -1)
        return dp2[i][j];
        if(matrix[i][j] == 1)
        return dp2[i][j] = matrix[i][j] + solve2(i , j + 1 , n , m , matrix , dp2);
        else if(matrix[i][j] == 2)
        return dp2[i][j] = matrix[i][j] + solve2(i + 1, j , n , m , matrix , dp2);
        else
        return dp2[i][j] = matrix[i][j] + max(solve2(i , j + 1 , n , m , matrix , dp2) , solve2(i + 1 , j , n , m , matrix , dp2));
    }
public:
vector<int> FindWays(vector<vector<int>>&matrix){
    // Code here
    int n = matrix.size() ;
    int m = matrix[0].size();
    vector<vector<int>>dp1(n , vector<int>(m , -1)), dp2(n , vector<int>(m , -1));
    int x = solve1(0 , 0 , n , m , matrix , dp1);
    int y = solve2(0 , 0 , n , m , matrix , dp2);
    if(y < 0)
    y = 0;
    return {x,y};
}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>matrix(n, vector<int>(n, 0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				cin >> matrix[i][j];
		}
		Solution obj;
		vector<int> ans = obj.FindWays(matrix);
		for(auto i: ans)cout << i << " ";
		cout << "\n";
	}
	return 0;
}  // } Driver Code Ends