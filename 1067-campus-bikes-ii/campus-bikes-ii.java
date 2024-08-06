class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] dp = new int[n][1 << m];
        return dfs(workers, bikes, dp, 0, 0);
    }

    private int dfs(int[][] workers, int[][] bikes, int[][] dp, int idx, int mask) {
        if (idx == workers.length) {
            return 0;
        }

        if (dp[idx][mask] != 0) {
            return dp[idx][mask];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((mask & (1 << i)) == 0) {
                int distance = getDistance(workers[idx], bikes[i]);
                int newResult = distance + dfs(workers, bikes, dp, idx + 1, mask | (1 << i));
                result = Math.min(result, newResult);
            }
        }

        dp[idx][mask] = result;
        return result;
    }

    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}