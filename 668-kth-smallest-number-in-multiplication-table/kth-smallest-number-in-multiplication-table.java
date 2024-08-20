class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n, result = -1;;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (!isEnough(mid, m, n, k)) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        return result;
    }

    private boolean isEnough(int x, int m, int n, int k) {
        int count = 0;
        for (int row = 1; row <= m; row++) {
            // Each row has row, 2 * row, 3 * row ... n * row
            // So mid / row will tell if the mid value is in the row or next one
            count += Math.min(x / row, n);
        }
        return count >= k;
    }
}