class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] ps = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int top = (i > 0) ? ps[i - 1][j] : 0;
                int left = (j > 0) ? ps[i][j - 1] : 0;
                int topLeft = (Math.min(i, j) > 0) ? ps[i - 1][j - 1] : 0;
                ps[i][j] = top + left - topLeft + matrix[i][j];
            }
        }
        
        int result = 0;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                for (int c1 = 0; c1 < cols; c1++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        int top = (r1 > 0) ? ps[r1 - 1][c2] : 0;
                        int left = (c1 > 0) ? ps[r2][c1 - 1] : 0;
                        int topLeft = (Math.min(r1, c1) > 0) ? ps[r1 - 1][c1 - 1] : 0;
                        int sum = ps[r2][c2] - top - left + topLeft;
                        if (sum == target) result++;
                    }
                }
            }
        }
        return result;
    }
}