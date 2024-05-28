class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, spent = 0, result = 0;
        for (int end = 0; end < n; end++) {
            spent += cost[end];
            while (spent > maxCost) {
                spent -= cost[start];
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
