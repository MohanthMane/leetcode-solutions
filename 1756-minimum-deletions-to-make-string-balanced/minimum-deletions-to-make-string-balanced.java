class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] bCountToLeft = new int[n];
        int[] aCountToRight = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            bCountToLeft[i] = count;
            if (s.charAt(i) == 'b') count++;
        }

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            aCountToRight[i] = count;
            if (s.charAt(i) == 'a') count++;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, bCountToLeft[i] + aCountToRight[i]);
        }
        return result;
    }
}