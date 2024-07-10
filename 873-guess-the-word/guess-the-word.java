/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        int matches = 0;
        while (matches != 6) {
            String guess = words[random.nextInt(words.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String word: words) {
                if (getMatches(word, guess) == matches) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
    }

    private int getMatches(String a, String b){
        int matches = 0;
        for(int i = 0; i < a.length(); i ++){
            if(a.charAt(i) == b.charAt(i)){
                matches++;
            }
        }
        return matches;
    }
}