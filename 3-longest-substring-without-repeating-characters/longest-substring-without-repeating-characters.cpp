class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        unordered_map<char, int> m;
        int i = 0, j = 0;
        while(i<=j and j<s.length()) {
            if (m[s[j]] == 0) {
                m[s[j++]]++;
            } else {
                res = max(res, (j - i));
                while (m[s[j]] != 0) {
                    m[s[i++]]--;
                }
            }
        }
        return max(res, j-i);
    }
};