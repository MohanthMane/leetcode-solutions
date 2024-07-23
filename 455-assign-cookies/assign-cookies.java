class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;

        int result = 0;
        while (j < s.length && i < g.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}