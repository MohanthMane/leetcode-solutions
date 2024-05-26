class Solution {

    private static final int mod = 1000000007;
    private int[][][] dp;

    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
        for (int[][] array2D : dp) {
            for (int[] array1D : array2D) {
                Arrays.fill(array1D, -1);
            }
        }
        return solve(n, 0, 0);
    }

    private int solve(int remainingDays, int absentCount, int consecutiveLateDays) {
        if (absentCount >= 2 || consecutiveLateDays >= 3) return 0;
        if (remainingDays == 0) {
            return 1;
        }
        if (dp[remainingDays][absentCount][consecutiveLateDays] != -1) return dp[remainingDays][absentCount][consecutiveLateDays];

        int result = solve(remainingDays - 1, absentCount + 1, 0) % mod;
        result = (result + solve(remainingDays - 1, absentCount, 0)) % mod;
        result = (result + solve(remainingDays - 1, absentCount, consecutiveLateDays + 1)) % mod;

        dp[remainingDays][absentCount][consecutiveLateDays] = result;
        return result;
    }
}