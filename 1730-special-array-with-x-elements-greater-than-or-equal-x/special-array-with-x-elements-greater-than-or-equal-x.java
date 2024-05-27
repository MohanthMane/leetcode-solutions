class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) continue;
            m.put(nums[i], i);
        }
        int l = 0, r = nums[nums.length - 1];
        while (l <= r) {
            int mid = (l + r) / 2;
            int greaterElements = nums.length - m.get(m.ceilingKey(mid));
            if (greaterElements == mid) {
                return mid;
            } else if (greaterElements > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
