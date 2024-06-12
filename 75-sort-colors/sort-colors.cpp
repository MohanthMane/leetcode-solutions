class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> count(3, 0);
        for (int x: nums) {
            count[x]++;
        }
        int j = 0;
        for(int i = 0; i<3; i++) {
            int c = count[i];
            while(c--) {
                nums[j++] = i;
            }
        }
    }
};