// { Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


int dx[] = {0, 0,-1, 1};
int dy[] = {-1, 1, 0, 0};
class Solution{
 
	public:
	bool isValid(int i, int j, int n, int m, vector<vector<char>> &mat) {
	    return (i>=0 and i<n and j>=0 and j<m and mat[i][j]=='.');
	}
	
	int numberOfCells(int n, int m, int r, int c, int u, int d, vector<vector<char>> &mat)
	{
		// Your code goes here
		vector<vector<bool>> vis(n+1,vector<bool>(m+1,false));
		queue<vector<int>> q;
		q.push({r,c,0,0});
		vis[r][c]=true;
		int ans=0;
		while(!q.empty()) {
		    vector<int> vec=q.front();
		    q.pop();
		    mat[vec[0]][vec[1]]='1';
		    ans++;
		    for(int j=0; j<4; ++j) {
		        int x=vec[0]+dx[j], y=vec[1]+dy[j];
		        if(isValid(x,y,n,m,mat) and !vis[x][y]) {
		            if((vec[2]==u and dx[j]==-1) || (vec[3]==d and dx[j]==1)) {
		                continue;
		            }
		            else {
		                vis[x][y]=true;
		                q.push({x,y,vec[2]+(dx[j]==-1),vec[3]+(dx[j]==1)});
		            }
		        }
		    }
		}
		
		return ans;
	}

};
// { Driver Code Starts.

int main() 
{
   	
   	int t;
    cin >> t;

    while (t--)
    {
    	int n, m, r, c, u, d;
        cin >> n >> m >> r >> c >> u >> d;
        
        vector<vector<char>> mat(n, vector<char>(m, '.'));

        for(int i = 0; i < n; i++)
        {
        	for(int j = 0; j < m; j++)
        	{
        		cin >> mat[i][j];
        	}
        }

      

        Solution obj;
        cout << obj.numberOfCells(n, m, r, c, u, d, mat) << "\n";
    
    }

    return 0;
}


  // } Driver Code Ends