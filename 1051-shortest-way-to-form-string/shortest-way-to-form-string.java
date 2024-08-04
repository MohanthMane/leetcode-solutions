class Solution {
    // After some arbitrary concatenations of source with itself,
    // we will be able to get target as a subsequence of source.
    // But simulating this will be a costly operation. So instead
    // of actual concatenation, we just reset the source pointer
    public int shortestWay(String source, String target) {
        int m = source.length(), n = target.length();
        int ans = 0, j = 0;
        while (j < n) {
            int i = 0;
            boolean ok = false;
            while (i < m && j < n) {
                if (source.charAt(i) == target.charAt(j)) {
                    ok = true;
                    ++j;
                }
                ++i;
            }
            if (!ok) {
                return -1;
            }
            ++ans;
        }
        return ans;
    }
}