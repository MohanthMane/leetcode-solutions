class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.putIfAbsent(s, 0);
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                count++;
            }
            if (count == k) return s;
        }
        return "";
    }
}