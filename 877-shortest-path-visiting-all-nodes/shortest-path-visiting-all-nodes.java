class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisitedMask = (1 << n) - 1;
        // [mask, node, steps]
        Queue<int[]> queue = new LinkedList<>();
        Set<Pair> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{1 << i, i, 0});
            seen.add(new Pair(1 << i, i));
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == allVisitedMask) {
                return current[2];
            }
            for (int neighbor: graph[current[1]]) {
                int newMask = current[0] | (1 << neighbor);
                Pair newPair = new Pair(newMask, neighbor);
                if (!seen.contains(newPair)) {
                    seen.add(newPair);
                    queue.offer(new int[]{newMask, neighbor, current[2] + 1});
                }
            }
        }
        return -1;
    }
}