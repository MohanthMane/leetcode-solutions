class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 0;
        char[] sentence = s.toCharArray();
        int i = 0, lastLineWidth = 0;
        while (i < s.length()) {
            int width = 0;
            while (true) {
                width = width + widths[sentence[i] - 'a'];
                if (width > 100) {
                    break;
                }
                i++;
                if (i == s.length()) {
                    lastLineWidth = width;
                    break;
                }
            }
            line++;
        }
        return new int[]{line, lastLineWidth};
    }
}