class Solution {
    public int maxProduct(String[] words) {
        List<Integer> masks = new ArrayList<>();
        for (String word: words) {
            int mask = 0;
            for (char c: word.toCharArray()) {
                mask = mask | (1 << (c - 'a'));
            }
            masks.add(mask);
        }

        int result = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = masks.get(i), b = masks.get(j);
                boolean eligible = true;
                for (int k = 0; k < 26; k++) {
                    int ak = (a >> k) & 1, bk = (b >> k) & 1;
                    if (ak + bk == 2) {
                        eligible = false;
                        break;
                    }
                }
                if (eligible) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}