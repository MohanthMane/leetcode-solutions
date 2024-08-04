class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int requiredEdges = n - 1, connectedEdges = 0;
        DSU dsu = new DSU(n);

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.offer(new Edge(i, j, cost));
            }
        }

        int cost = 0;
        while (connectedEdges < requiredEdges) {
            Edge edge = edges.poll();
            if (dsu.union(edge.from, edge.to)) {
                connectedEdges++;
                cost += edge.cost;
            }
        }
        return cost;
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

class DSU {
    int[] parents;
    
    public DSU(int n) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (px > py) {
            parents[px] = py;
        } else {
            parents[py] = px;
        }
        return true;
    }
}