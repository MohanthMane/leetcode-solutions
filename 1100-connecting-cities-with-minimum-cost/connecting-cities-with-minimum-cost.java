class Solution {
    public int minimumCost(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int cost = 0;
        Arrays.sort(connections, Comparator.comparing(a -> a[2]));
        for (int[] connection: connections) {
            if (dsu.union(connection[0], connection[1])) {
                cost += connection[2];
            }
        }
        if (dsu.components != 1) return -1;
        return cost;
    }
}

class DSU {
    int[] parents;
    int components;

    public DSU(int n) {
        this.parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        this.components = n;
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
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
        this.components -= 1;
        return true;
    }
}