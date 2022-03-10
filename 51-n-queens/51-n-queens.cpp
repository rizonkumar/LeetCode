class Solution {

public:
    bool isSafe(int row, int col, vector<string> board, int n){
        // check upper diagonal
        int duprow = row;
        int dupcol = col;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        // left direction
        col = dupcol;
        row = duprow;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        // downward diagonal
        row = duprow;
        col = dupcol;
        while(row <n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        // after finding in all the direction and didnt not find queen return true;
        return true;
    }
    
public:
    void solve(int col, vector<string> &board, vector<vector<string>> &ans, int n){
        // base case
        // the moment u reach the nth index its over so store the ans.
        if(col == n){
            ans.push_back(board);
            return;
        }
        // for every column, i was trying every row
        for(int row=0; row<n; row++){
            // is it safe to place queen
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q'; // the moment its safe, you place the Q and move to next column
                // now u call the recursion for the next col now
                solve(col+1, board, ans, n);
                board[row][col] = '.';  // when u come back from the recursion u make sure u omit the queue // back-track
            }
        }
    }
    
    
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        vector<string> board(n);
        string s(n, '.');
        for(int i=0; i<n; i++){
            board[i] = s;
        }
        
        solve(0, board, ans, n);
        return ans;
    }
};