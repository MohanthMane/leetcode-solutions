class Solution {
    
    private Map<String, Integer> dp;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.dp = new HashMap<>();
        return solve(books, shelfWidth, shelfWidth, 0, 0);
    }

    private int solve(int[][] books, int shelfWidth, int remainingWidth, int idx, int maxHeight) {
        if (idx == books.length) return 0;

        String key = idx + "_" + remainingWidth;
        if (dp.containsKey(key)) return dp.get(key);

        int width = books[idx][0], height = books[idx][1];

        int newRow = height + solve(books, shelfWidth, shelfWidth - width, idx + 1, height);
        int sameRow = Integer.MAX_VALUE;
        if (remainingWidth >= width) {
            int heightDiff = Math.max(height - maxHeight, 0);
            sameRow = heightDiff + solve(books, shelfWidth, remainingWidth - width, idx + 1, Math.max(height, maxHeight));
        }
        
        int result = Math.min(newRow, sameRow);
        dp.put(key, result);
        return result;
    }
}