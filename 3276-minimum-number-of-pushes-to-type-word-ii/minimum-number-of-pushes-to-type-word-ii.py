class Solution:
    def minimumPushes(self, word: str) -> int:
        count = [0] * 26
        for c in word:
            count[ord(c) - ord("a")] += 1
        count.sort(reverse=True)

        result = 0
        for i in range(26):
            if count[i] == 0:
                break
            result += (i // 8 + 1) * count[i]

        return result