class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        solve(n, "", result, 1);
        return result;
    }

    private void solve(int n, String temp, List<String> result, int prev) {
        if (n == 0) {
            result.add(temp);
            return;
        }

        if (prev == 0) {
            solve(n - 1, temp + "1", result, 1);
        } else {
            solve(n - 1, temp + "0", result, 0);
            solve(n - 1, temp + "1", result, 1);
        }
    }
}