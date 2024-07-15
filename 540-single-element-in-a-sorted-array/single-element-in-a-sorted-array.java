class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, n = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            int lowerBound = getLowerBound(nums, nums[mid], 0, mid);

            if ((mid - 1 < 0 || (mid - 1 >= 0 && nums[mid - 1] != nums[mid]))
                    && (mid + 1 >= n || (mid + 1 < n && nums[mid + 1] != nums[mid]))) {
                return nums[mid];
            } else {
                if (lowerBound % 2 == 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private int getLowerBound(int[] nums, int num, int l, int r) {
        int left = l, right = r, result = r;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == num) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}