class Solution {

    public boolean placeWordInCrossword(char[][] board, String word) {
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isPossible(board, word, row, col, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPossible(char[][] grid, String word, int row, int col, int rows, int cols) {
        if (grid[row][col] == '#') {
            return false;
        }
        if (isValid(grid, row, col + 1, rows, cols) && isPossible(grid, word, row, col, rows, cols, 0, -1)) {
            return true;
        }
        if (isValid(grid, row, col - 1, rows, cols) && isPossible(grid, word, row, col, rows, cols, 0, 1)) {
            return true;
        }
        if (isValid(grid, row + 1, col, rows, cols) && isPossible(grid, word, row, col, rows, cols, -1, 0)) {
            return true;
        }
        return isValid(grid, row - 1, col, rows, cols) && isPossible(grid, word, row, col, rows, cols, 1, 0);
    }

    private boolean isPossible(char[][] board, String word, int row, int col, int rows, int cols, int d1, int d2) {
        int i = 0, len = word.length();
        while (i < len && inRange(row, col, rows, cols) && (board[row][col] == ' ' || board[row][col] == word.charAt(i))) {
            row += d1;
            col += d2;
            i++;
        }
        if (i < len) {
            return false;
        }
        return isValid(board, row, col, rows, cols);
    }

    private boolean inRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private boolean isValid(char[][] board, int row, int col, int rows, int cols) {
        if (inRange(row, col, rows, cols)) {
            return board[row][col] == '#';
        }
        return true;
    }
}