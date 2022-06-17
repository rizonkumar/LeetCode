class Solution(object):
    def decode(self, A, first):
        res = [first]
        for a in A:
            res.append(res[-1] ^ a)
        return res
        