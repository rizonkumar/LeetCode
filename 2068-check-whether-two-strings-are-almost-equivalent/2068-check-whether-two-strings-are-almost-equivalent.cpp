class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        // Brute Force
        for(char ch = 'a'; ch <= 'z'; ch++){
            int freq1 = 0;
            int freq2 = 0;
            for(auto &i: word1){
                if(i == ch) freq1++;
            }
            for(auto &i: word2){
                if(i == ch) freq2++;
            }
            
            if(abs(freq1 - freq2) > 3) return false;       
        }
        return true;
    }
};