class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                long r = bombs[i][2];
                if (r * r >= distance(bombs[i], bombs[j])) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < bombs.length; i++) {
            int detonations = dfs(i, new HashSet<>(), graph);
            result = Math.max(result, detonations);
        }
        return result;
    }

    private int dfs(int bomb, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(bomb);
        int count = 1;
        for (int neighbor: graph.getOrDefault(bomb, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                count += dfs(neighbor, visited, graph);
            }
        }
        return count;
    }

    private long distance(int[] c1, int[] c2) {
        long x1 = c1[0], y1 = c1[1], r1 = c1[2];
        long x2 = c2[0], y2 = c2[1], r2 = c2[2];
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}