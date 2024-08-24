class Solution {

    private Integer[][] dp;

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        this.dp = new Integer[n][m];
        return solve(grid, n, m, 0, 0);
    }

    private int solve(int[][] grid, int n, int m, int x, int y) {
        if (x >= n || y >= m) return Integer.MAX_VALUE;
        if (x == n - 1 && y == m - 1) return grid[x][y];
        if (dp[x][y] != null) return dp[x][y];

        int result = grid[x][y] + Math.min(
            solve(grid, n, m, x + 1, y), solve(grid, n, m, x, y + 1)
        );
        return dp[x][y] = result;
    }
}