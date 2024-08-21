class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0, result = 0;
        for (int num: nums) {
            sum = (((sum + num) % k) + k) % k;
            result += m.getOrDefault(sum, 0);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}