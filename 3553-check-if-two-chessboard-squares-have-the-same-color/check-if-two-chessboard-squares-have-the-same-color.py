class Solution:
    def checkTwoChessboards(self, c1: str, c2: str) -> bool:
        black_start = ['a', 'c', 'e', 'g']

        def get_color(c):
            if c[0] in black_start:
                if int(c[1]) % 2 == 0:
                    return 0
                else:
                    return 1
            else:
                if int(c[1]) % 2 == 0:
                    return 1
                else:
                    return 0
        return get_color(c1) == get_color(c2)