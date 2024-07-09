class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        DSU dsu = new DSU(n);
        int time = -1;
        for (int[] log : logs) {
            dsu.union(log[1], log[2]);
            if (dsu.components == 1) {
                return log[0];
            }
            time = log[0];
        }
        return dsu.components == 1 ? time : -1;
    }
}

class DSU {
    int[] parents;
    int components;

    public DSU(int size) {
        this.parents = new int[size];
        this.components = size;
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent != yParent) {
            if (xParent > yParent) {
                parents[yParent] = xParent;
            } else {
                parents[xParent] = yParent;
            }
            components--;
        }
    }
}