class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int aliveNeighbors = getAliveNeighbors(board, i, j);

                if (board[i][j] == 1 && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                    board[i][j] = -1; // Alive to dead
                } else if (board[i][j] == 0 && aliveNeighbors == 3) {
                    board[i][j] = 2; // Dead to alive
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] <= 0) {
                    board[i][j] = 0;
                } else if (board[i][j] > 0) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getAliveNeighbors(int[][] board, int i, int j) {
        int n = board.length, m = board[0].length;
        int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
        };
        int count = 0;
        for (int[] direction : directions) {
            int newX = i + direction[0], newY = j + direction[1];
            if (isValid(n, m, newX, newY)) {
                // Consider cell alive if it's either still alive (1) or was alive but is now dead (-1)
                if (board[newX][newY] == 1 || board[newX][newY] == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int n, int m, int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
