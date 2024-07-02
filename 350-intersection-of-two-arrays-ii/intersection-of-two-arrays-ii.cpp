class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> m1, m2;
        for (auto k: nums1) m1[k]++;
        for (auto k: nums2) m2[k]++;

        vector<int> res;
        for (auto k: m1) {
            if (m2[k.first] != 0) {
                int n = min(k.second, m2[k.first]);
                while (n--) res.push_back(k.first);
            }
        }

        return res;
    }
};