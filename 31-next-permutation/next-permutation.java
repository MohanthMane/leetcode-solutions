class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2, pivot = -1;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
            i--;
        }
        if (pivot != -1) {
            int j = n - 1;
            while (nums[j] <= nums[pivot]) j--;
            swap(nums, pivot, j);
        }
        reverse(nums, pivot + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}