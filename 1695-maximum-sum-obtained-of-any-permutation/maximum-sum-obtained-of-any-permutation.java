class Solution {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        long res = 0, mod = (long) 1e9 + 7;
        int n = nums.length;
        int[] line = new int[n];
        for (int[] request : requests) {
            line[request[0]] += 1;
            if (request[1] + 1 < n) {
                line[request[1] + 1] -= 1;
            }
        }
        for (int i = 1; i < n; ++i) {
            line[i] += line[i - 1];
        }
        
        Arrays.sort(nums);
        Arrays.sort(line);
        for (int i = 0; i < n; ++i) {
            res += (long) nums[i] * line[i];
        }
        return (int) (res % mod);
    }
}