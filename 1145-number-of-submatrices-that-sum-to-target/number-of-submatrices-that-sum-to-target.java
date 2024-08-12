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
                Map<Integer, Integer> countMap = new HashMap<>();
                countMap.put(0, 1);
                for (int c = 0; c < cols; c++) {
                    int top = (r1 > 0) ? ps[r1 - 1][c] : 0;
                    int sum = ps[r2][c] - top;
                    result += countMap.getOrDefault(sum - target, 0);
                    countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }
}