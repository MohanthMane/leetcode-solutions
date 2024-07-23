class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int absoluteNum = Math.abs(nums[i]);
            if (nums[absoluteNum] < 0) {
                return absoluteNum;
            }
            nums[absoluteNum] *= -1;
        }
        return -1;
    }
}