class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<PairWithDistance> queue = new LinkedList<>();
        int n = rooms.length, m = rooms[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new PairWithDistance(i, j, 0));
                }
            }
        }

        int[][] directions = new int[][] {
                {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };
        while (!queue.isEmpty()) {
            PairWithDistance curr = queue.poll();
            for (int[] dir : directions) {
                int newX = dir[0] + curr.x, newY = dir[1] + curr.y;
                if (isValid(n, m, newX, newY) && rooms[newX][newY] > curr.dist + 1) {
                    rooms[newX][newY] = curr.dist + 1;
                    queue.offer(new PairWithDistance(newX, newY, curr.dist + 1));
                }
            }
        }
    }

    private boolean isValid(int n, int m, int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}

class PairWithDistance {
    int x, y, dist;

    public PairWithDistance(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
