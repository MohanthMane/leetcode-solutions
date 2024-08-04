class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        double[] probs = new double[n + 1];
        Arrays.fill(probs, 0.0);
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(a -> -a.y));
        queue.offer(new Pair(start_node, 1.0));
        probs[start_node] = 1.0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            for (Pair neighbor : graph.getOrDefault(current.x, new ArrayList<>())) {
                double newProbability = current.y * neighbor.y;
                if (newProbability > probs[neighbor.x]) {
                    probs[neighbor.x] = newProbability;
                    queue.offer(new Pair(neighbor.x, newProbability));
                }
            }
        }
        return probs[end_node];
    }
}

class Pair {

    int x;
    double y;

    public Pair(int x, double y) {
        this.x = x;
        this.y = y;
    }
}