class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        return solve(piles, 0, piles.length - 1, true, dp) > 0;
    }

    private int solve(int[] piles, int s, int e, boolean isAlice, int[][] dp) {
        if (s > e) return 0;
        if (dp[s][e] != 0) return dp[s][e];

        if (isAlice) {
            int left = piles[s] + solve(piles, s + 1, e, false, dp);
            int right = piles[e] + solve(piles, s, e - 1, false, dp);
            return dp[s][e] = Math.max(left, right);
        } else {
            int left = solve(piles, s + 1, e, true, dp) - piles[s];
            int right = solve(piles, s, e - 1, true, dp) - piles[e];
            return dp[s][e] = Math.max(left, right);
        }
    }
}