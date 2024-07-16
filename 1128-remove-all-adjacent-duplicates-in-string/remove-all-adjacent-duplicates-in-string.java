class Solution {
    public String removeDuplicates(String s) {
        List<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || stack.getLast() != c) {
                stack.addLast(c);
            } else {
                stack.removeLast();
            }
        }
        return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}