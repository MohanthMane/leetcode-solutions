class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxElement = Arrays.stream(arr1).max().orElse(0);
        int[] freq = new int[maxElement + 1];
        for (int i = 0; i < arr1.length; i++) {
            freq[arr1[i]]++;
        }
        int[] result = new int[arr1.length];
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (freq[arr2[i]] > 0) {
                result[idx++] = arr2[i];
                freq[arr2[i]]--;
            } 
        }
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                result[idx++] = i;
                freq[i]--;
            }
        }
        return result;
    }
}