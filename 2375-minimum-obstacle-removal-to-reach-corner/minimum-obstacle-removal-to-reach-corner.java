import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Pair(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int x = current.x, y = current.y, cost = current.cost;

            if (x == n - 1 && y == m - 1) {
                return cost;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0], newY = y + direction[1];
                if (isValid(grid, newX, newY) && cost + grid[newX][newY] < dist[newX][newY]) {
                    dist[newX][newY] = cost + grid[newX][newY];
                    pq.offer(new Pair(newX, newY, dist[newX][newY]));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }

    class Pair {
        int x, y, cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
