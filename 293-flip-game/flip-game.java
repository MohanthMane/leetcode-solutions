class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < currentState.length(); i++) {
            StringBuilder nextState = new StringBuilder(currentState);
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                nextState.setCharAt(i - 1, '-');
                nextState.setCharAt(i, '-');
                result.add(nextState.toString());
            }
        }
        return result;
    }
}