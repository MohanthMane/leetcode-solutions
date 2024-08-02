class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int result = -1;
        int l = 0, r = Arrays.stream(bloomDay).max().orElse(1);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(bloomDay, mid, k, m)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] bloomDay, int mid, int k, int requiredBouquets) {
        int bouquets = 0, count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= requiredBouquets;
    }
}