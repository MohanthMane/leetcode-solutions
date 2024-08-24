class Solution {
    
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int last = sub.get(sub.size() - 1);
            if (nums[i] > last) {
                sub.add(nums[i]);
            } else {
                int leftMostGreaterIndex = find(sub, nums[i]);
                sub.set(leftMostGreaterIndex, nums[i]);
            }
        }
        return sub.size();
    }

    private int find(List<Integer> sub, int num) {
        int l = 0, r = sub.size() - 1;
        int result = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (sub.get(mid) >= num) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}