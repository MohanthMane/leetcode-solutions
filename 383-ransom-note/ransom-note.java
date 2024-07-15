class Solution {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> ransomNoteCounts = makeCountsMap(ransomNote);
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);
        
        for (char c : ransomNoteCounts.keySet()) {
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            int countInRansomNote = ransomNoteCounts.get(c);
            if (countInMagazine < countInRansomNote) {
                return false;
            }
        }
        
        return true;
    }

    private Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }
    
}