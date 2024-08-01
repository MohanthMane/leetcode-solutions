class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int[] workingSet = new int[k + k];
        int n = cardPoints.length, idx = 0;
        for (int i = n - k; i < n; i++) {
            workingSet[idx++] = cardPoints[i];
        }
        for (int i = 0; i < k; i++) {
            workingSet[idx++] = cardPoints[i];
        }

        int sum = 0, result = 0;
        for (int i = 0; i < workingSet.length; i++) {
            if (i >= k) {
                sum -= workingSet[i - k];
            }
            sum += workingSet[i];
            result = Math.max(result, sum);
        }
        return result;
    }
}