class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();
        for (int[] row : matrix) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                rMin = Math.min(rMin, row[j]);
            }
            rowMin.add(rMin);
        }

        List<Integer> colMax = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int[] cols : matrix) {
                cMax = Math.max(cMax, cols[i]);
            }
            colMax.add(cMax);
        }

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}