class Solution:
    def decode(self, A, first):
        return list(accumulate([first] + A, lambda x, y: x ^ y))
        