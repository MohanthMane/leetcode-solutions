class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (Pair indices: twoSum(nums, -nums[i], i + 1, nums.length - 1)) {
                result.add(List.of(nums[i], nums[indices.x], nums[indices.y]));
            }
        }
        return result;
    }

    private List<Pair> twoSum(int[] nums, int target, int start, int end) {
        List<Pair> indices = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                indices.add(new Pair(start, end));
                start++;
                end--;
                while (start < end && nums[start - 1] == nums[start]) start++;
                while (end > start && nums[end] == nums[end + 1]) end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return indices;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}