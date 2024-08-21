class Solution {

    private Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {
        this.dp = new Integer[stoneValue.length + 1];
        int aliceScore = solve(stoneValue, 0);

        if (aliceScore > 0) return "Alice";
        if (aliceScore < 0) return "Bob";
        return "Tie";    
    }

    private int solve(int[] value, int idx) {
        if (idx == value.length) return 0;
        
        if (dp[idx] != null) return dp[idx];

        int result = Integer.MIN_VALUE, score = 0;
        for (int stones = 0; stones < 3; stones++) {
            if (idx + stones >= value.length) continue;
            
            score += value[idx + stones];
            result = Math.max(result, score - solve(value, idx + stones + 1));
        }
        return dp[idx] = result;
    }
}