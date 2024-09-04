class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        d = defaultdict(list)
        for i in range(n):
            for val in grid[i]:
                d[val].append(i)
        vals = list(d.items())
        cache = defaultdict(int)

        def solve(i, mask):
            if i >= len(vals):
                return 0
            
            key = str(i) + "," + str(mask)
            if key in cache.keys():
                return cache[key]

            res = solve(i + 1, mask)
            for j in vals[i][1]:
                if not mask & (1 << j):
                    res = max(res, vals[i][0] + solve(i + 1, mask | (1 << j)))
            cache[key] = res
            return res

        return solve(0, 0)