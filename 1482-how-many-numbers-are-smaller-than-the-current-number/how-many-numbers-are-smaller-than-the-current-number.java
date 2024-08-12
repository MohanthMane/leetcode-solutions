class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buckets = new int[101];
        for (int num: nums) {
            buckets[num]++;
        }
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                result[i] = 0;
            } else {
                result[i] = buckets[num - 1];
            }
        }
        return result;
    }
}