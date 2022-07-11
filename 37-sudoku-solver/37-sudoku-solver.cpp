class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
    
    bool solve(vector<vector<char>>& board){
        // finding the first empty so we traverse 
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[0].size(); j++){
                
                // if it empty
                if(board[i][j] == '.'){
                    //try out every possibility from 1 to 9
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] ='.';   //remove it if false
                        }
                    }
                    // if not able to place then return false
                    return false;
                }
            }
        }
        return true;
    }
    
    bool isValid(vector<vector<char>>& board, int row, int col, char c){
        // check for all three rule in single iteration
        for(int i = 0; i < 9; i++){
            //row is changing & col is stable
            if(board[i][col] == c) 
                return false;
            
            //col is changing & row is stable
            if(board[row][i] == c) 
                return false;
            
            //for sub-matrix
            if(board[3 * (row / 3) + i /3][3 * (col / 3) + i % 3] == c) 
                return false;
        }
        return true;
    }
};