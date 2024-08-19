class Solution {

    private static final int mod = (int) 1e9 + 7;

    public int numberOfUniqueGoodSubsequences(String binary) {
        int n = binary.length();
        long zeroCount = 0, oneCount = 0;
        long extra = 0;
        for (char c: binary.toCharArray()) {
            if (c == '0') {
                extra = 1;
                zeroCount = (zeroCount + oneCount) % mod;
            } else {
                oneCount = (oneCount + zeroCount + 1) % mod;
            }
        }
        return (int) (zeroCount + oneCount + extra) % mod;
    }
}