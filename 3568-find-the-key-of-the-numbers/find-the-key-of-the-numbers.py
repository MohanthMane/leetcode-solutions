class Solution:
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        a = ((4 - len(str(num1))) * '0') + str(num1)
        b = ((4 - len(str(num2))) * '0') + str(num2)
        c = ((4 - len(str(num3))) * '0') + str(num3)

        d = ''
        for i in range(4):
            d += str(min(int(a[i]), int(b[i]), int(c[i])))
        return int(d)