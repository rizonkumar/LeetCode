class Solution {
public:
    int titleToNumber(string columnTitle) {
        int result = 0;
        for(char c: columnTitle){
            int d = c - 'A' + 1;
            // conversion
            result = result * 26 + d;
        }
        return result;
    }
};