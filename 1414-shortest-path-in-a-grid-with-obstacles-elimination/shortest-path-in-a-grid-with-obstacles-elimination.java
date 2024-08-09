class Solution {

    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        if (k >= n + m - 2) {
            return n + m - 2;
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{0, 0, 0, 0});
        visited.add("0,0,0");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], eliminations = current[2], steps = current[3];

            if (x == n - 1 && y == m - 1) {
                return steps;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0], newY = y + direction[1];
                if (isValid(newX, newY, n, m)) {
                    int newEliminations = eliminations + (grid[newX][newY] == 1 ? 1 : 0);
                    String state = newX + "," + newY + "," + newEliminations;
                    if (newEliminations <= k && !visited.contains(state)) {
                        visited.add(state);
                        queue.offer(new int[]{newX, newY, newEliminations, steps + 1});
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
