class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }

        List<Integer> componentSizes = new ArrayList<>(dsu.componentSizes.values());
        long result = 0, remainingNodes = n;
        for (int size: componentSizes) {
            remainingNodes -= size;
            result += (size) * (remainingNodes);
        }
        return result;
    }
}

class DSU {
    int[] parents;
    Map<Integer, Integer> componentSizes;

    public DSU(int n) {
        this.parents = new int[n];
        this.componentSizes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            componentSizes.put(i, 1);
        }
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]); // Path compression
        }
        return parents[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            int updatedComponentSize = componentSizes.get(py) + componentSizes.get(px);
            if (px > py) {
                parents[py] = px;
                componentSizes.put(px, updatedComponentSize);
                componentSizes.remove(py);
            } else {
                parents[px] = py;
                componentSizes.put(py, updatedComponentSize);
                componentSizes.remove(px);
            }
        }
    }
}