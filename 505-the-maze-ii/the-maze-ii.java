class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        Set<String> seen = new HashSet<>();
        int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        Map<String, Integer> distances = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        seen.add(getHash(start));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction: directions) {
                int r = current[0], c = current[1];
                int distance = 0;
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                    r += direction[0];
                    c += direction[1];
                    distance++;
                }
                distance--;
                r -= direction[0];
                c -= direction[1];
                String key = getHash(new int[]{r, c});
                int newDistance = current[2] + distance;
                if (distances.getOrDefault(key, Integer.MAX_VALUE) > newDistance) {
                    distances.put(key, newDistance);
                    queue.add(new int[]{r, c, newDistance});
                }
            }
        }
        return distances.getOrDefault(getHash(destination), -1);
    }

    private String getHash(int[] cell) {
        return cell[0] + "_" + cell[1];
    }
}