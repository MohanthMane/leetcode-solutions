class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int n = warehouse.length;
        int[] maxHeightSupported = new int[n];
        maxHeightSupported[0] = warehouse[0];
        for (int i = 1; i < n; i++) {
            maxHeightSupported[i] = Math.min(warehouse[i], maxHeightSupported[i - 1]);
        }

        int i = n - 1, result = 0, j = 0;
        while (i >= 0 && j < boxes.length) {
            if (maxHeightSupported[i] >= boxes[j]) {
                result++;
                i--;
                j++;
            } else {
                i--;
            }
        }
        return result;
    }
}