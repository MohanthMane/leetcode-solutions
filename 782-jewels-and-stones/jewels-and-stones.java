class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneCount = new HashMap<>();
        for (char c: stones.toCharArray()) {
            stoneCount.put(c, stoneCount.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        for (char c: jewels.toCharArray()) {
            result += stoneCount.getOrDefault(c, 0);
        }
        return result;
    }
}