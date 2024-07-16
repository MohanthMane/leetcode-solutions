import math

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        l, r = 0, int(math.sqrt(c))
        while l <= r:
            ans = l * l + r * r
            if ans == c:
                return True
            elif ans < c:
                l += 1
            else:
                r -= 1
        return False
