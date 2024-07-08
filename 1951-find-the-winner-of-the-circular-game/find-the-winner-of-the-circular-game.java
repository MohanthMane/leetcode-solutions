class Solution {
    public int findTheWinner(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }

    private int helper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (helper(n - 1, k) + k) % n;
    }
}