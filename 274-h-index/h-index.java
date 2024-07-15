class Solution {
    public int hIndex(int[] citations) {
        int l = 1, r = 1000, result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isHIndex(mid, citations)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private boolean isHIndex(int h, int[] citations) {
        int count = 0;
        for (int citation: citations) {
            if (citation >= h) {
                count++;
            }
            if (count == h) {
                return true;
            }
        }
        return false;
    }
}