class Solution {

    private Integer[][] dp;

    public int strangePrinter(String s) {
        this.dp = new Integer[s.length()][s.length()];
        s = removeDuplicates(s);
        return solve(s, 0, s.length() - 1);
    }

    private int solve(String s, int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != null) return dp[l][r];

        int result = 1 + solve(s, l + 1, r);
        for (int k = l + 1; k <= r; k++) {
            if (s.charAt(l) == s.charAt(k)) {
                // Try splitting
                int cycles = solve(s, l, k - 1) + solve(s, k + 1, r);
                result = Math.min(result, cycles);
            }
        }
        return dp[l][r] = result;
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}