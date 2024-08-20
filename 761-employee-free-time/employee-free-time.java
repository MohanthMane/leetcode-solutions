class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (List<Interval> s : schedule) {
            for (Interval i : s) {
                line.put(i.start, line.getOrDefault(i.start, 0) + 1);
                line.put(i.end, line.getOrDefault(i.end, 0) - 1);
            }
        }

        int count = 0;
        boolean found = false;
        List<Interval> result = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> x : line.entrySet()) {
            count += x.getValue();
            if (found) {
                result.get(result.size() - 1).end = x.getKey();
                found = false;
            }
            if (count == 0) {
                result.add(new Interval(x.getKey(), -1));
                found = true;
            }
        }

        if (found) {
            result.remove(result.size() - 1);
        }

        return result;
    }
}
