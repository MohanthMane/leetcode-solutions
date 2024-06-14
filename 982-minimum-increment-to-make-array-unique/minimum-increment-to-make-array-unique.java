class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int[] count = new int[nums.length + max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        int result = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > 1) {
                int duplicates = count[i] - 1;
                result += duplicates;
                count[i] = 1;
                count[i + 1] += duplicates;
            }
        }
        return result;
    }
}