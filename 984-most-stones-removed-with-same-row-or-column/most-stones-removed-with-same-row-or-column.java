class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(20002);

        for (int[] stone: stones) {
            dsu.union(stone[0], stone[1] + 10001);
        }

        return n - dsu.components;
    }
}

class DSU {
    int[] parents;
    int components;
    Set<Integer> uniqueNodes;

    public DSU(int n) {
        this.components = 0;
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        this.uniqueNodes = new HashSet<>();
    }

    public int find(int x) {
        if (!uniqueNodes.contains(x)) {
            uniqueNodes.add(x);
            this.components++;
        }
        if (parents[x] != x) {
            return parents[x] = find(parents[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (px < py) {
                parents[py] = px;
            } else {
                parents[px] = py;
            }
            this.components--;
        }
    }
}