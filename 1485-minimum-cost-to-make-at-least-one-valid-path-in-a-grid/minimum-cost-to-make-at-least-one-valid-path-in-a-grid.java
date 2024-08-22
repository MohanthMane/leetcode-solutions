class Solution {

    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] changes = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(changes[i], Integer.MAX_VALUE);

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int x = current[0], y = current[1], change = current[2];
            if (x == m - 1 && y == n - 1) return change;

            for (int i = 0; i < directions.length; i++) {
                int[] direction = directions[i];
                int newX = x + direction[0], newY = y + direction[1];
                if (newX >= m || newY >= n || newX < 0 || newY < 0) continue;

                if ((i + 1) == grid[x][y]) {
                    if (change < changes[newX][newY]) {
                        queue.addFirst(new int[] {newX, newY, change});
                        changes[newX][newY] = change;
                    }
                } else {
                    if (change + 1 < changes[newX][newY]) {
                        queue.addLast(new int[] {newX, newY, change + 1});
                        changes[newX][newY] = change + 1;
                    }
                }
            }
        }
        return changes[m - 1][n - 1];
    }
}