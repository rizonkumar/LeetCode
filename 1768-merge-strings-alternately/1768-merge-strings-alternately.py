class Solution:
    def mergeAlternately(self, w1, w2):
        return ''.join(a + b for a, b in zip_longest(w1, w2, fillvalue=''))
        