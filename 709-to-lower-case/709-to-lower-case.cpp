class Solution {
public:
    string toLowerCase(string s) {
        for(char &c : s){
            // ASCII value of upper is 65 to 90, lower is 97 // So c+= 32 // 65 + 32 = 97
            if(c >='A' && c <='Z') c+=32;   
        }
        
        return s;
    }
};