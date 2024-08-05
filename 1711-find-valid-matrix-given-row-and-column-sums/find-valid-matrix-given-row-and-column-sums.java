class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[] currRowSum = new int[n];
        int[] currColSum = new int[m];

        int[][] result = new int[n][m];
        int i = 0, j = 0;
        while (i < n && j < m) {
            result[i][j] = Math.min(rowSum[i] - currRowSum[i], colSum[j] - currColSum[j]);
            currRowSum[i] += result[i][j];
            currColSum[j] += result[i][j];

            if (currRowSum[i] == rowSum[i]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}