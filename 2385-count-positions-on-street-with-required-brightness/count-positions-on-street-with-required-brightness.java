class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] line = new int[n + 1];
        for (int[] light: lights) {
            line[Math.max(0, light[0] - light[1])]++;
            line[Math.min(n, light[0] + light[1] + 1)]--;
        }

        int result = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += line[i];
            if (sum >= requirement[i]) {
                result++;
            }
        }
        return result;
    }
}