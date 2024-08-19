class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> rowOrder = topSort(rowConditions, k);
        List<Integer> colOrder = topSort(colConditions, k);
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0];
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (Objects.equals(rowOrder.get(i), colOrder.get(j))) {
                    matrix[i][j] = rowOrder.get(i);
                }
            }
        }
        return matrix;
    }

    private List<Integer> topSort(int[][] edges, int n) {
        int[] degrees = new int[n + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            degrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topSorted = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            topSorted.add(current);
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                degrees[neighbor]--;
                if (degrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return topSorted;
    }
}