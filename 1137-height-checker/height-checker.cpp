class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> expected;
        for (int h: heights) expected.push_back(h);
        
        sort(expected.begin(), expected.end());
        int res = 0;
        for (int i = 0; i < expected.size(); i++) {
            if (expected[i] != heights[i]) res++;
        }
        
        return res;
    }
};