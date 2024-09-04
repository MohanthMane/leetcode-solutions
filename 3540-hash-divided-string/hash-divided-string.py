class Solution:
    def stringHash(self, s, k):
        n = len(s)
        count = n // k
        result = ''

        def get_hash(sub_str):
            sum = 0
            for c in sub_str:
                sum += (ord(c) - ord('a'))
            sum %= 26
            return chr(ord('a') + sum)

        for i in range(0, n, k):
            result += get_hash(s[i : i + k])
        return result

        