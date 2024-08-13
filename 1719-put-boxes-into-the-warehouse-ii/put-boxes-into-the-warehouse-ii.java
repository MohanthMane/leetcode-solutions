class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        Arrays.sort(boxes);

        int l = 0, r = n - 1, result = 0, boxIdx = boxes.length - 1;

        while (l <= r && boxIdx >= 0) {
            if (boxes[boxIdx] <= warehouse[l]) {
                result++;
                l++;
            } else if (boxes[boxIdx] <= warehouse[r]) {
                result++;
                r--;
            }
            boxIdx--;
        }
        return result;
    }
}