class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        for (int starti = 0; starti <= rows - 3; starti++) {
            for (int startj = 0; startj <= cols - 3; startj++) {
                int i = starti, j = startj;
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagicSquare(int[][] grid, int r, int c) {
        int[] rowSum = new int[3], colSum = new int[3], diagonalSum = new int[2];
        Set<Integer> seen = new HashSet<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                seen.add(grid[i][j]);
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!seen.contains(i)) return false;
        }

        int rowIdx = 0;
        for (int i = r; i < r + 3; i++) {
            int sum = 0;
            for (int j = c; j < c + 3; j++) {
                sum += grid[i][j];
            }
            rowSum[rowIdx] = sum;
            if (rowIdx != 0 && sum != rowSum[rowIdx - 1]) {
                return false;
            }
            rowIdx++;
        }

        int colIdx = 0;
        for (int j = c; j < c + 3; j++) {
            int sum = 0;
            for (int i = r; i < r + 3; i++) {
                sum += grid[i][j];
            }
            colSum[colIdx] = sum;
            if (colIdx != 0 && sum != colSum[colIdx - 1]) {
                return false;
            }
            colIdx++;
        }

        return (grid[r][c] + grid[r + 2][c + 2]) == (grid[r][c + 2] + grid[r + 2][c]);
    }
}