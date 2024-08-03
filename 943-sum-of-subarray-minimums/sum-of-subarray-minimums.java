class Solution {

    private static final int mod = 1000000007;

    // OneNote
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            prevSmaller[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nextSmaller[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftInfluence = i - prevSmaller[i];
            long rightInfluence = nextSmaller[i] - i;
            long totalContribution = leftInfluence * rightInfluence;
            long sum = totalContribution * arr[i];
            result = (result + sum) % mod;
        }
        return (int) result;
    }
}