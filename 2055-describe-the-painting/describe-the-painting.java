class Solution {

    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> line = new TreeMap<>();
        for (int[] segment : segments) {
            line.put(segment[0], line.getOrDefault(segment[0], 0L) + segment[2]);
            line.put(segment[1], line.getOrDefault(segment[1], 0L) - segment[2]);
        }

        List<List<Long>> result = new ArrayList<>();
        long i = 0, sum = 0;
        for (int j : line.keySet()) {
            if (sum > 0) {
                result.add(Arrays.asList(i, (long) j, sum));
            }
            sum += line.get(j);
            i = j;
        }
        return result;
    }
}