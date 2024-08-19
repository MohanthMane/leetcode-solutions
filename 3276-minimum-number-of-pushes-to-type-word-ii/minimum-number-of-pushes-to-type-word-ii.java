class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c: word.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<Char> queue = new PriorityQueue<>(Comparator.comparing(a -> -a.count));
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] != 0) queue.offer(new Char(c, count[c - 'a']));
        }
        System.out.println(queue.size());
        int result = 0, presses = 1, remaining = 8;
        while (!queue.isEmpty()) {
            Char current = queue.poll();
            if (remaining > 0) {
                remaining--;
            } else {
                System.out.println("I'm here");
                remaining = 7;
                presses++;
            }
            result += current.count * presses;
        }
        return result;
    }
}

class Char {
    Character c;
    Integer count;

    public Char(Character c, Integer count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Char{" +
                "c=" + c +
                ", count=" + count +
                '}';
    }
}