class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num: nums) {
            seen.add(num);
            seen.add(reverse(num));
        }
        return seen.size();
    }

    private int reverse(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            result.append(num % 10);
            num /= 10;
        }
        return Integer.parseInt(result.toString());
    }
}