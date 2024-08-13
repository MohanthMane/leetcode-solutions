class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n + 1), bob = new DSU(n + 1);

        int edgesRequired = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int a = edge[1], b = edge[2];
                if (alice.areNotConnected(a, b) || bob.areNotConnected(a, b)) {
                    edgesRequired++;
                    alice.union(a, b);
                    bob.union(a, b);
                }
            }
        }

        for (int[] edge : edges) {
            int a = edge[1], b = edge[2];
            if (edge[0] == 1) {
                if (alice.areNotConnected(a, b)) {
                    edgesRequired++;
                    alice.union(a, b);
                }
            } else if (edge[0] == 2) {
                if (bob.areNotConnected(a, b)) {
                    edgesRequired++;
                    bob.union(a, b);
                }
            }
        }

        if (alice.isConnectedGraph() && bob.isConnectedGraph()) {
            return edges.length - edgesRequired;
        }
        return -1;
    }
}

class DSU {

    int[] parents;
    int[] ranks;
    int components;

    public DSU(int size) {
        this.components = size - 1;
        this.parents = new int[size];
        this.ranks = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent != yParent) {
            if (ranks[xParent] > ranks[yParent]) {
                parents[yParent] = xParent;
                ranks[xParent] += ranks[yParent];
            } else {
                parents[xParent] = yParent;
                ranks[yParent] += ranks[xParent];
            }
            this.components--;
        }
    }

    public boolean areNotConnected(int x, int y) {
        return find(x) != find(y);
    }

    public boolean isConnectedGraph() {
        return components == 1;
    }
}