class DSU {

    int[] parents;
    int[] ranks;
    int components;

    public DSU(int size) {
        this.components = size;
        this.parents = new int[size];
        this.ranks = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
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

    public int getMaxRank() {
        int max = 0;
        for (int rank : ranks) {
            max = Math.max(max, rank);
        }
        return max;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.components == 1;
    }
}