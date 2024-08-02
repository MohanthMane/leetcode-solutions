class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int higher) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n == 0) {
            result.add(List.of(lower, higher));
            return result;
        }
        
        if (lower < nums[0]) {
            result.add(List.of(lower, nums[0] - 1));
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                continue;
            }
            result.add(List.of(nums[i - 1] + 1, nums[i] - 1));
        }

        if (higher > nums[n - 1]) {
            result.add(List.of(nums[n - 1] + 1, higher));
        }

        return result;
    }
}