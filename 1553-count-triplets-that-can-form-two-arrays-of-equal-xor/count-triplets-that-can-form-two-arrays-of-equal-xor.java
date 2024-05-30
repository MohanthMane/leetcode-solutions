class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int a = prefixXor[j - 1] ^ (i == 0 ? 0 : prefixXor[i - 1]);
                    int b = prefixXor[k] ^ prefixXor[j - 1];
                    if (a == b) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}