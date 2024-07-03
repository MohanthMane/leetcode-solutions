class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xToYMap = new HashMap<>();
        for (int[] point: points) {
            int x = point[0], y = point[1];
            if (!xToYMap.containsKey(x)) {
                xToYMap.put(x, new HashSet<>());
            }
            xToYMap.get(x).add(y);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int p1x = points[i][0], p1y = points[i][1];
                int p2x = points[j][0], p2y = points[j][1];

                if (p1x == p2x || p1y == p2y) continue;
                if (xToYMap.get(p1x).contains(p2y) && xToYMap.get(p2x).contains(p1y)) {
                    minArea = Math.min(minArea, Math.abs(p1x - p2x) * Math.abs(p1y - p2y));
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}