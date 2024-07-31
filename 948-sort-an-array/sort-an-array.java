class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) return new int[] {nums[l]};
        if (l < r) {
            int mid = l + (r - l) / 2;
            int[] left = mergeSort(nums, l, mid);
            int[] right = mergeSort(nums, mid + 1, r);
            return merge(left, right);
        }
        return new int[]{};
    }

    private int[] merge(int[] left, int[] right) {
        int l = 0, r = 0, idx = 0;
        int n = left.length, m = right.length;
        int[] result = new int[n + m];
        while (l < n && r < m) {
            if (left[l] <= right[r]) {
                result[idx++] = left[l++];
            } else {
                result[idx++] = right[r++];
            }
        }

        while (l < n) {
            result[idx++] = left[l++];
        }

        while (r < m) {
            result[idx++] = right[r++];
        }

        return result;
    }
}