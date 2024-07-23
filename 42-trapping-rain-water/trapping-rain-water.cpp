class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int i = 0, j = n - 1, lmax = height[i], rmax = height[j];
        int area = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                lmax = max(lmax, height[i]);
                area += (lmax - height[i]);
                i++;
            } else {
                rmax = max(rmax, height[j]);
                area += (rmax - height[j]);
                j--;
            }
        }
        return area;
    }
};