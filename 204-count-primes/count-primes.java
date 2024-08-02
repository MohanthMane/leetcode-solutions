class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] sieve = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (sieve[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = true;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (sieve[i] == false) result++;
        }
        return result;
    }
}