class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length, lineLength = (int) 2e5;
        int[] line = new int[lineLength];
        int[] sum = new int[lineLength];

        for (int i = 0; i < n / 2; i++) {
            int min = Math.min(nums[i], nums[n - i - 1]) + 1;
            int max = Math.max(nums[i], nums[n - i - 1]) + limit;
            line[min]++;
            line[max + 1]--;
            sum[nums[i] + nums[n - i - 1]]++;
        }

        for (int i = 1; i < line.length; i++) {
            line[i] += line[i - 1];
        }
        
        int result = n;
        for (int possibleSum = 2; possibleSum < 2e5; possibleSum++) {
            result = Math.min(result, n - line[possibleSum] - sum[possibleSum]);
        }
        return result;
    }
}