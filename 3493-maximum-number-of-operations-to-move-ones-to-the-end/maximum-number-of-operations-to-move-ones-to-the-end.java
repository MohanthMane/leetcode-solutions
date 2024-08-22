class Solution {
    public int maxOperations(String s) {
        int ans = 0, cnt = 0; 
        for (int n = s.length(), i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i + 1 == n || s.charAt(i + 1) == '1') {
                    cnt++;
                }
            } else {
                ans += cnt;
            }
        }
        return ans; 
    }
}