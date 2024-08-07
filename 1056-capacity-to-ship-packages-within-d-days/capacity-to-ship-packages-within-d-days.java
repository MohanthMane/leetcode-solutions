class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = Arrays.stream(weights).min().orElse(0);
        int maxWeight = Arrays.stream(weights).sum();
        int result = maxWeight;

        while (minWeight <= maxWeight) {
            int mid = minWeight + (maxWeight - minWeight) / 2;
            if (canBeShipped(weights, mid, days)) {
                result = mid;
                maxWeight = mid - 1;
            } else {
                minWeight = mid + 1;
            }
        }
        return result;
    }

    private boolean canBeShipped(int[] weights, int k, int days) {
        int currWeight = 0, daysNeeded = 1;
        for (int weight : weights) {
            if (weight > k) return false;
            if (currWeight + weight > k) {
                daysNeeded++;
                currWeight = 0;
            }
            currWeight += weight;
        }
        return daysNeeded <= days;
    }
}