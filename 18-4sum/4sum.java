import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (List<Integer> indices : threeSum(nums, target - nums[i], i + 1)) {
                result.add(List.of(nums[i], nums[indices.get(0)], nums[indices.get(1)], nums[indices.get(2)]));
            }
        }
        return result;
    }

    private List<List<Integer>> threeSum(int[] nums, long target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (Pair indices : twoSum(nums, target - nums[i], i + 1, nums.length - 1)) {
                result.add(List.of(i, indices.x, indices.y));
            }
        }
        return result;
    }

    private List<Pair> twoSum(int[] nums, long target, int start, int end) {
        List<Pair> indices = new ArrayList<>();
        while (start < end) {
            long sum = nums[start] + nums[end];
            if (sum == target) {
                indices.add(new Pair(start, end));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) start++;
                while (start < end && nums[end] == nums[end + 1]) end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return indices;
    }

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
