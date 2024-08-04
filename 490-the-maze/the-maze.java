class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        Set<String> seen = new HashSet<>();
        int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        seen.add(getHash(start));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }
            for (int[] direction: directions) {
                int r = current[0], c = current[1];
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                    r += direction[0];
                    c += direction[1];
                }

                r -= direction[0];
                c -= direction[1];
                String key = getHash(new int[]{r, c});
                if (!seen.contains(key)) {
                    seen.add(key);
                    queue.add(new int[]{r, c});
                }
            }
        }
        return false;
    }

    private String getHash(int[] cell) {
        return cell[0] + "_" + cell[1];
    }
}