class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = getLowerBound(nums, target);
        if (lowerBound == -1) {
            return new int[]{-1, -1};
        }
        int upperBound = getUpperBound(nums, target);
        return new int[]{lowerBound, upperBound};
    }

    private int getLowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                result = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private int getUpperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                result = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}