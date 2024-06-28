class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.y - a.y);
        for (int i = 0; i < n; i++) {
            queue.add(new Pair(i, degree[i]));
        }

        Map<Integer, Integer> nodeToImportance = new HashMap<>();
        int importance = n;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            nodeToImportance.put(pair.x, importance);
            importance--;
        }
        
        long result = 0;
        for (int[] road : roads) {
            result += nodeToImportance.get(road[0]) + nodeToImportance.get(road[1]);
        }
        return result;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair add(Pair toAdd) {
        return new Pair(this.x + toAdd.x, this.y + toAdd.y);
    }
}