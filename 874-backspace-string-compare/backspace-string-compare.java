class Solution {
    public boolean backspaceCompare(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int aSpace = 0, bSpace = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (a.charAt(i) == '#') {
                    aSpace++;
                    i--;
                } else if (aSpace > 0) {
                    aSpace--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (b.charAt(j) == '#') {
                    bSpace++;
                    j--;
                } else if (bSpace > 0) {
                    bSpace--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (a.charAt(i) != b.charAt(j)) {
                    return false;
                }
            } 
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
