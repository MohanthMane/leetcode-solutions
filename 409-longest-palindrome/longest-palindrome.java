class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result += entry.getValue();
                charCount.put(entry.getKey(), 0);
            } else {
                result += entry.getValue() - 1;
                charCount.put(entry.getKey(), 1);
            }
        }
        
        charCount = charCount.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        return charCount.isEmpty() ? result : result + 1;
    }
}
