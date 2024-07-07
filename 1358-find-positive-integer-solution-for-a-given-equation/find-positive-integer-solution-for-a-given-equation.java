/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int val = customFunction.f(x, y);
            if (val == z) {
                result.add(List.of(x, y));
                x++;
                y--;
            } else if (val < z) {
                x++;
            } else {
                y--;
            }
        }
        return result;
    }
}