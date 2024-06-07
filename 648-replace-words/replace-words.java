class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        int index = 0;
        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (dict.contains(prefix)) {
                    break;
                }
            }
            words[index] = prefix;
            index++;
        }
        return String.join(" ", words);
    }
}