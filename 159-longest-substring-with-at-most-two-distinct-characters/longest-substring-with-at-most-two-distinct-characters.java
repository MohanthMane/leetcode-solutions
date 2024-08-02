class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            while (countMap.size() > 2) {
                char toRemove = s.charAt(left);
                countMap.put(toRemove, countMap.getOrDefault(toRemove, 0) - 1);
                if (countMap.get(toRemove) == 0) {
                    countMap.remove(toRemove);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}