class Solution {

    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            letterIndicesTable.putIfAbsent(t.charAt(i), new ArrayList<>());
            letterIndicesTable.get(t.charAt(i)).add(i);
        }

        int currMatchIndex = -1;
        for (char letter : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter)) {
                return false;
            }

            boolean isMatched = false;
            for (Integer matchIndex : letterIndicesTable.get(letter)) {
                if (currMatchIndex < matchIndex) {
                    currMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched)
                return false;
        }
        return true;
    }
}