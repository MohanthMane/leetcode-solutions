class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;
        if (target == 0 || target == x || target == y || target == x + y) return true;

        Set<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        visited.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currX = curr.x, currY = curr.y;

            if (currX + currY == target || currX == target || currY == target) {
                return true;
            }

            List<Pair> nextStates = Arrays.asList(
                new Pair(x, currY),
                new Pair(currX, y),
                new Pair(0, currY),
                new Pair(currX, 0),
                new Pair(currX - Math.min(currX, y - currY), currY + Math.min(currX, y - currY)),
                new Pair(currX + Math.min(currY, x - currX), currY - Math.min(currY, x - currX))
            );

            for (Pair nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }
        return false;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
