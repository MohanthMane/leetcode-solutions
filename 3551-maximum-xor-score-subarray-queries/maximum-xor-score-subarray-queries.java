class Solution {
    
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] score = new int[n][n];
        for (int[] line : score) Arrays.fill(line, -1);

        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = i ; j < n; j++) {
        		score[i][j] = getScore(score, max, nums, i, j);
        	}
        }
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++)
        	result[i] = max[queries[i][0]][queries[i][1]];
        return result;
    }
	
	private static int getScore(int[][] score, int[][] max, int[] nums, int x, int y) {
		if (score[x][y] != -1)
			return score[x][y];
		if (x == y) {
			max[x][y] = nums[x];
			return score[x][y] = nums[x];
		}
		score[x][y] = getScore(score, max, nums, x + 1, y) ^ getScore(score, max, nums, x, y - 1);
		max[x][y] = Math.max(score[x][y], Math.max(max[x + 1][y], max[x][y - 1]));
		return score[x][y];
	}
}