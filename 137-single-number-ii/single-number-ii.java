class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            for (int num: nums) {
                oneCount += (num >> i) & 1;
            }
            if (oneCount % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}