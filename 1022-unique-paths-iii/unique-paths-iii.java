class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int toVisit = 0, sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }

                if (grid[i][j] != -1) {
                    toVisit++;
                }
            }
        }

        return dfs(grid, sx, sy, ex, ey, 0, toVisit);
    }

    private int dfs(int[][] grid, int i, int j, int ex, int ey, int visited, int toVisit) {
        if (i == ex && j == ey) {
            if (visited == toVisit - 1) return 1;
            return 0;
        }

        int val = grid[i][j];
        grid[i][j] = 3;
        int n = grid.length, m = grid[0].length;

        int left = isValid(i, j - 1, n, m) && grid[i][j - 1] != 3 && grid[i][j - 1] != -1 ? dfs(grid, i, j - 1, ex, ey, visited + 1, toVisit) : 0;
        int right = isValid(i, j + 1, n, m) && grid[i][j + 1] != 3 && grid[i][j + 1] != -1 ? dfs(grid, i, j + 1, ex, ey, visited + 1, toVisit) : 0;
        int down = isValid(i + 1, j, n, m) && grid[i + 1][j] != 3  && grid[i + 1][j] != -1? dfs(grid, i + 1, j, ex, ey, visited + 1, toVisit) : 0;
        int up = isValid(i - 1, j, n, m) && grid[i - 1][j] != 3 && grid[i - 1][j] != -1? dfs(grid, i - 1, j, ex, ey, visited + 1, toVisit) : 0;

        grid[i][j] = val;
        return left + right + up + down;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}