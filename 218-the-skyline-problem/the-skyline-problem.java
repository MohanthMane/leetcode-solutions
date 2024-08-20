// https://just4once.gitbooks.io/leetcode-notes/content/leetcode/divide-and-conquer/218-the-skyline-problem.html
class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkyline(buildings, 0, buildings.length - 1);
    }

    private LinkedList<List<Integer>> getSkyline(int[][] buildings, int l, int r) {
        if (l > r) return new LinkedList<>();
        if (l == r) {
            int height = buildings[l][2];
            int startX = buildings[l][0];
            int endX = buildings[l][1];
            return new LinkedList<>() {{
                add(List.of(startX, height));
                add(List.of(endX, 0));
            }};
        }
        int mid = (l + r) / 2;
        LinkedList<List<Integer>> leftSkyline = getSkyline(buildings, l, mid);
        LinkedList<List<Integer>> rightSkyline = getSkyline(buildings, mid + 1, r);
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    private LinkedList<List<Integer>> mergeSkylines(LinkedList<List<Integer>> left, LinkedList<List<Integer>> right) {
        LinkedList<List<Integer>> skyline = new LinkedList<>();
        int leftHeight = 0, rightHeight = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            int x = 0;
            if (left.peek().get(0) < right.peek().get(0)) {
                x = left.peek().get(0);
                leftHeight = left.poll().get(1);
            } else if (right.peek().get(0) < left.peek().get(0)) {
                x = right.peek().get(0);
                rightHeight = right.poll().get(1);
            } else {
                x = left.peek().get(0);
                leftHeight = left.poll().get(1);
                rightHeight = right.poll().get(1);
            }
            int maxHeight = Math.max(leftHeight, rightHeight);
            if (skyline.isEmpty() || skyline.getLast().get(1) != maxHeight) {
                skyline.add(List.of(x, maxHeight));
            }
        }
        skyline.addAll(left);
        skyline.addAll(right);
        return skyline;
    }
}