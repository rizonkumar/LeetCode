class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if(s1 == s2) return true;   
        
        vector<int> ans;
        for(int i = 0; i < (int)s2.size();i++){
            if(s1[i] != s2[i]) ans.push_back(i);
        }
        
        if(ans.size() == 2){
            int x= ans[0], y = ans[1];
            if(s1[x] == s2[y] && s1[y] == s2[x]) return true;
        }
        
        return false;
    }
};