class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        int n = numBottles, m = numExchange, drinkable = n;
        while (n >= m) {
            result += drinkable;
            drinkable = (n / m);
            n = drinkable + (n % m);
        }
        return result + drinkable;
    }
}