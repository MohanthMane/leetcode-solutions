class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                Set<String> vis = new HashSet<>();
                double[] ans = {-1.0}; // Using array for pass by reference. Primitives are not pass by reference
                double temp = 1.0;
                dfs(dividend, divisor, graph, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    private void dfs(String node, String dest, Map<String, Map<String, Double>> graph, Set<String> vis, double[] ans, double temp) {
        if (vis.contains(node))
            return;

        vis.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, graph, vis, ans, temp * val);
        }
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());

            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }

        return graph;
    }
}
