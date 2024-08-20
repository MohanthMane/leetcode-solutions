class Solution {
    public int maxProduct(String[] words) {
        // bitmask -> max length of all strings with same bitmask
        Map<Integer, Integer> maskMap = new HashMap<>();
        for (String word: words) {
            int mask = 0;
            for (char c: word.toCharArray()) {
                mask = mask | (1 << (c - 'a'));
            }
            maskMap.put(mask, Math.max(maskMap.getOrDefault(mask, 0), word.length()));
        }

        int result = 0;
        for (int x: maskMap.keySet()) {
            for (int y: maskMap.keySet()) {
                if ((x & y) == 0) {
                    result = Math.max(result, maskMap.get(x) * maskMap.get(y));
                }
            }
        }
        return result;
    }
}