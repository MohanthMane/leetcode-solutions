class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> resultSet = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        char[] tileArray = tiles.toCharArray();
        Arrays.sort(tileArray);
        backtrack(resultSet, new StringBuilder(), tileArray, used);
        return resultSet.size();
    }
    
    private void backtrack(Set<String> resultSet, StringBuilder current, char[] tiles, boolean[] used) {
        if (current.length() > 0) {
            resultSet.add(current.toString());
        }
        if (current.length() == tiles.length) {
            return;
        }

        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.append(tiles[i]);
            backtrack(resultSet, current, tiles, used);
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}