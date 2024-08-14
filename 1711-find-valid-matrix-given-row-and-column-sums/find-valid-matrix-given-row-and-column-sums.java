class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[] currRowSum = new int[n];
        int[] currColSum = new int[m];
        int row = 0, col = 0;

        int[][] result = new int[n][m];
        while (row < n && col < m) {
            int toAdd = Math.min(rowSum[row] - currRowSum[row], colSum[col] - currColSum[col]);
            currRowSum[row] += toAdd;
            currColSum[col] += toAdd;
            result[row][col] = toAdd;

            if (currRowSum[row] == rowSum[row]) {
                row++;
            } else {
                col++;
            }
        }
        return result;
    }
}