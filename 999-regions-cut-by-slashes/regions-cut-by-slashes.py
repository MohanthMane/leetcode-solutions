class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        n, m = len(grid), len(grid[0])
        rows, cols = 3 * n, 3 * m
        upscaled_grid = [[0] * cols for _ in range(rows)]

        for i in range(n):
            for j in range(m):
                r, c = 3 * i, 3 * j
                if grid[i][j] == '/':
                    upscaled_grid[r][c + 2] = 1
                    upscaled_grid[r + 1][c + 1] = 1
                    upscaled_grid[r + 2][c] = 1
                elif grid[i][j] == '\\':
                    upscaled_grid[r][c] = 1
                    upscaled_grid[r + 1][c + 1] = 1
                    upscaled_grid[r + 2][c + 2] = 1
        
        print(upscaled_grid)
        def dfs(r, c, visit):
            if (r < 0 or c < 0 or r == rows or c == cols or upscaled_grid[r][c] == 1 or (r, c) in visit): 
                return
            visit.add((r, c))
            neighbors = [[r + 1, c], [r, c + 1], [r - 1, c], [r, c - 1]]
            
            for nr, nc in neighbors:
                dfs(nr, nc, visit)

        visit = set()
        res = 0
        for r in range(rows):
            for c in range(cols):
                if upscaled_grid[r][c] == 0 and (r, c) not in visit:
                    dfs(r, c, visit)
                    res += 1
        return res
            