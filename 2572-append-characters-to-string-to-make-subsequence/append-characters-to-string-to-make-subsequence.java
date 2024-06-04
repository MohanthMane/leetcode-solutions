class Solution {
    public int appendCharacters(String s, String t) {
        int tIndex = 0, sIndex = 0;
        while (tIndex < t.length() && sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }
        return t.length() - tIndex;
    }
}