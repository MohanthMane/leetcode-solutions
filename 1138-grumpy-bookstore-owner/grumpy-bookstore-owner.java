class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unSatisfied = 0, maxUnsatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (i >= minutes) {
                unSatisfied -= customers[i - minutes] * grumpy[i - minutes];
            }
            unSatisfied += customers[i] * grumpy[i];
            maxUnsatisfied = Math.max(maxUnsatisfied, unSatisfied);
        }

        int totalCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (grumpy[i] ^ 1);
        }
        return totalCustomers + maxUnsatisfied;
    }
}