class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int a = 0, b = 0;
                    for (int l = i; l < j; l++) a ^= arr[l];
                    for (int l = j; l <= k; l++) b ^= arr[l];
                    if (a == b) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}