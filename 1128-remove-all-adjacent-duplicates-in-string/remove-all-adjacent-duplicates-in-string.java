class Solution {
    public String removeDuplicates(String s) {
        List<Character> stack = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || stack.getLast() != c) {
                stack.add(c);
            } else {
                stack.remove(stack.size() - 1);
            }
        }
        return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}