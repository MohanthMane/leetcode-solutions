class Solution {
    private static final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int idx = 0, x = rStart, y = cStart;
        for (int step = 1, direction = 0; idx < rows * cols;) {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[idx][0] = x;
                        result[idx][1] = y;
                        ++idx;
                    }
                    x += directions[direction][0];
                    y += directions[direction][1];
                }
                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return result;
    }
}