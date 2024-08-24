// https://leetcode.com/problems/queue-reconstruction-by-height/solutions/2211641/visual-explanation-java-greedy
class Solution {
    // Insight: Two people who share the same height must have their k values sorted in ascending order.
    public int[][] reconstructQueue(int[][] people) {
        // People with same height must maintain relative order
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> result = new LinkedList<>();
        for (int[] person: people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }
}