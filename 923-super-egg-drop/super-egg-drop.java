class Solution {

    /*
     * "How many moves do you need to check N floors if you have K eggs"
     * to:
     * "How many floors can you check given M moves available and K eggs".
     * 
     * If you can solve this second problem than you can just increase the moves M
     * one by one until you are able to check a number of floors larger or equal to
     * the number N which the problem requires.
     * He then defined
     * dp[M][K] as the maximum number of floors that you can check within M moves
     * given K eggs
     * 
     * A move essentially is dropping an egg and it either breaks or doesn't break.
     * Case A: The egg breaks and now you have spent 1 move (M=M-1) and also lost 1
     * egg (K=K-1). You can still check dp[M-1][K-1] floors, with your remaining
     * eggs and moves.
     * Case B: The egg remains and you only loose one move (M=M-1). You can still
     * check dp[M-1][K] floors.
     * Additionally you just checked a floor by dropping the egg from it.
     * Therefore dp[M][K] = dp[M - 1][k - 1] + dp[M - 1][K] + 1
     * As you can see we can easily calculate how many floors we can check in M
     * moves if we know how many floors we can check in M-1 moves.
     * 
     * However we not only have to know how many floors we can can check with one
     * move less, but also how many we can check with one move and one egg less.
     * Therefore we have to calculate how many moves we can check for all number off eggs from 1 to K.
     */

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }
}