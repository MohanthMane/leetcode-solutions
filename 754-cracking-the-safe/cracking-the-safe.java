class Solution {
    public String crackSafe(int n, int k) {
        Set<String> visited = new HashSet<>();
        String initial = "0".repeat(n);
        StringBuilder result = new StringBuilder(initial);
        int totalCombinations = (int) Math.pow(k, n);
        visited.add(initial);
        dfs(result, totalCombinations, visited, n, k);
        return result.toString();
    }

    private boolean dfs(StringBuilder result, int totalCombinations, Set<String> visited, int n, int k) {
        if (visited.size() == totalCombinations) return true;

        String prefix = result.substring(result.length() - n + 1);
        for (int i = 0; i < k; i++) {
            char newChar = (char) (i + '0');
            String newPassword = prefix + newChar;
            if (visited.contains(newPassword)) continue;

            visited.add(newPassword);
            result.append(newChar);

            if (dfs(result, totalCombinations, visited, n, k)) return true;

            visited.remove(newPassword);
            result.deleteCharAt(result.length() - 1);
        }
        return false;
    }
}
