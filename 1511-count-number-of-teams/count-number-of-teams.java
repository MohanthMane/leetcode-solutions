class Solution {
    public int numTeams(int[] rating) {
        int increasingTeams = 0, n = rating.length;
        int[] leftSmaller = new int[n];
        int[] rightGreater = new int[n];
        int[] leftGreater = new int[n];
        int[] rightSmaller = new int[n];

        for (int i = 1; i < n; i++) {
            int smallCount = 0, greaterCount = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) smallCount++;
                else if (rating[j] > rating[i]) greaterCount++;
            }
            leftSmaller[i] = smallCount;
            leftGreater[i] = greaterCount;
        }

        for (int i = n - 2; i >= 0; i--) {
            int smallCount = 0, greaterCount = 0;
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) greaterCount++;
                else if (rating[j] < rating[i]) smallCount++;
            }
            rightGreater[i] = greaterCount;
            rightSmaller[i] = smallCount;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (leftSmaller[i] * rightGreater[i]);
            result += (leftGreater[i] * rightSmaller[i]);
        }
        return result;
    }
}