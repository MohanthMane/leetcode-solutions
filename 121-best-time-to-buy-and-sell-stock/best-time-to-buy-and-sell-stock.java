class Solution {
    public int maxProfit(int[] prices) {
        int valley = Integer.MAX_VALUE, result = 0;
        for (int price: prices) {
            if (price < valley) {
                valley = price;
            }
            result = Math.max(result, price - valley);
        }
        return result;
    }
}