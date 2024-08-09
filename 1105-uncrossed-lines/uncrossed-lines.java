class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, nums1, nums2, dp);
    }

    private int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve(i + 1, j + 1, nums1, nums2, dp);
        } else {
            dp[i][j] = Math.max(solve(i, j + 1, nums1, nums2, dp), solve(i + 1, j, nums1, nums2, dp));
        }
        return dp[i][j];
    }
}