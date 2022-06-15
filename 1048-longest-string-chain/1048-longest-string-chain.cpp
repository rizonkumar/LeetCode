/*
Explanation
Sort the words by word's length. (also can apply bucket sort)
For each word, loop on all possible previous word with 1 letter missing.
If we have seen this previous word, update the longest chain for the current word.
Finally return the longest word chain.


Complexity
Time O(NlogN) for sorting,
Time O(NSS) for the for loop, where the second S refers to the string generation and S <= 16.
Space O(NS)


*/

class Solution {
public:
    static bool compare(const string &s1, const string &s2) {
        return s1.length() < s2.length();
    }

    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), compare);
        unordered_map<string, int> dp;
        int res = 0;
        for (string w : words) {
            for (int i = 0; i < w.length(); i++) {
                string pre = w.substr(0, i) + w.substr(i + 1);
                dp[w] = max(dp[w], dp.find(pre) == dp.end() ? 1 : dp[pre] + 1);
            }
            res = max(res, dp[w]);
        }
        return res;
    }
};