class Solution {

    private Map<String, Integer> dp = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        return solve(cuts, 0, n);
    }

    private int solve(int[] cuts, int left, int right) {
        if (right - left == 1) return 0;

        String key = left + "_" + right;
        if (dp.containsKey(key)) return dp.get(key);

        int result = Integer.MAX_VALUE;
        for (int cut: cuts) {
            if (cut <= left || cut >= right) continue;
            int cost = right - left;
            cost += solve(cuts, left, cut) + solve(cuts, cut, right);
            result = Math.min(cost, result);
        }
        result = result == Integer.MAX_VALUE ? 0 : result;
        dp.put(key, result);
        return result;
    }
}