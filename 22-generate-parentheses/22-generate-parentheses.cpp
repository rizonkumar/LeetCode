class Solution {
public:
    vector <string> valid;

    void helper(string &s, int open, int close){

        // base condition
        if(open == 0 && close == 0){
            valid.push_back(s);
            return;
        }

        if(open > 0){
            s.push_back('(');
            helper(s, open - 1, close);
            s.pop_back();   // backtracking
        }

        if(close > 0){
            if(open < close){
                s.push_back(')');
                helper(s, open, close - 1);
                s.pop_back();
            }
        }
    }
    vector<string> generateParenthesis(int n) {
        string s;
        helper(s, n, n);
        return valid;
    }
};