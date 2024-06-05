class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] tempCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                tempCount[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], tempCount[i]);
            }
        }
        final List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}