class Solution {
    // When you have envelopes which have the same width, only one of them could be selected. Because you are going to solve this problem by LIS, you have to sort their heights in DESC order to guarantee their heights are NOT an Increasing Sequence
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] heights = new int[envelopes.length];
        int i = 0;
        for (int[] e: envelopes) {
            heights[i++] = e[1];
        }
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
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