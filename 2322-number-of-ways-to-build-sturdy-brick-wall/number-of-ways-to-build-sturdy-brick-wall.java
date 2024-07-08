class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        return solve(height, width, bricks, new Integer[height + 1][1 << width], 0, 0, 0);
    }

    private int solve(int h, int w, int[] brick, Integer[][] dp, int config, int curWidth, int prev){
        if (dp[h][prev] != null)
            return dp[h][prev];
        if (h == 0)
            return 1;
        if (curWidth == w)
            return solve(h - 1, w, brick, dp, 0, 0, config);

        int ans = 0;
        for (int b : brick){
            int size = curWidth + b;
            int newConfig = size < w ? config | (1 << size) : config;
            if (size > w || (newConfig & prev) > 0) continue;
            ans = (ans + solve(h, w, brick, dp, newConfig, size, prev)) % 1000000007;
        }

        return config == 0 ? dp[h][prev] = ans : ans; 
    }
}