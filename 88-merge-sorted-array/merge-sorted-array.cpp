class Solution {
public:
    void merge(vector<int>& a, int m, vector<int>& b, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 and j>=0) {
            if (b[j] > a[i]) {
                a[k--] = b[j--];
            } else {
                a[k--] = a[i--];
            }
        }
        while (i >= 0) a[k--] = a[i--];
        while (j >= 0) a[k--] = b[j--];
    }
};