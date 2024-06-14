class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> s = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (s.contains(nums[i])) {
                int destination = nums[i - 1] + 1;
                result = result + (destination - nums[i]);
                nums[i] = destination;
            }
            s.add(nums[i]);
        }
        return result;
    }
}