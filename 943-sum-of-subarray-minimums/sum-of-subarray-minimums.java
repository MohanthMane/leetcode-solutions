class Solution {

    private static final int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] dp = new int[n];

        // dp[i] Sum of minimums for subarrays ending at i
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();

            if (!s.isEmpty()) {
                int previousSmallerIdx = s.peek();
                dp[i] = dp[previousSmallerIdx] + (i - previousSmallerIdx) * arr[i];
            } else {
                dp[i] = (i + 1) * arr[i];
            }
            s.push(i);
        }

        long result = 0;
        for (int minimum: dp) {
            result = result + minimum;
            result %= mod;
        }
        return (int) result;
    }
}