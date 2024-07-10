class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                int j = 0;
                boolean possible = true;
                for (j = i; j < s.length(); j += i) {
                    if (!s.substring(j, j + i).equals(sub)) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    return true;
                }
            }
        }
        return false;
    }
}