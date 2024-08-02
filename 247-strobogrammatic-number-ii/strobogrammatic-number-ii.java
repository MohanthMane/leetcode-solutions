class Solution {

    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> rotatedDigits = new HashMap<>(Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6'));
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int stringLength = 0;
        // Expand around center
        if (n % 2 == 0) {
            queue.offer("");
        } else {
            queue.offer("0");
            queue.offer("1");
            queue.offer("8");
            stringLength = 1;
        }

        while (stringLength < n) {
            int size = queue.size();
            stringLength += 2;
            while (size-- > 0) {
                String current = queue.poll();
                result.add(current);
                for (Character digit : rotatedDigits.keySet()) {
                    // Use zeros only in the middle
                    if (stringLength == n && digit == '0') continue;
                    queue.offer(digit + current + rotatedDigits.get(digit));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}