class Solution {
    public long numberOfSubstrings(String s) {
        long[] count = new long[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        long result = 0;
        for (long c: count) {
            if (c != 0) {
                result += (c * (c - 1) / 2);
            }
        }
        return result + (long) s.length();
    }
}