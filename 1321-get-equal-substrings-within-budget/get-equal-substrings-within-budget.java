class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), start = 0, spent = 0, result = 0;
        for (int end = 0; end < n; end++) {
            spent += Math.abs(s.charAt(end) - t.charAt(end));
            while (spent > maxCost) {
                spent -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}