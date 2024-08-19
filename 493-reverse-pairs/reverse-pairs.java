class Solution {

    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) return new int[] {nums[l]};
        if (l < r) {
            int mid = l + (r - l) / 2;
            int[] left = mergeSort(nums, l, mid);
            int[] right = mergeSort(nums, mid + 1, r);

            int j = 0;
            for (int i = 0; i < left.length; i++) {
                while (j < right.length && left[i] > 2L * right[j]) {
                    j++;
                }
                count += j;
            }

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