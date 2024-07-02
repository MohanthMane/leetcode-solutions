class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> active = new TreeSet<>();
        int day = 1;
        for (int bulb: bulbs) {
            active.add(bulb);
            Integer lower = active.lower(bulb);
            Integer higher = active.higher(bulb);

            if ((lower != null && bulb - lower - 1 == k) || 
                (higher != null && higher - bulb - 1 == k)) {
                    return day;
                }
            day++;
        }
        return -1;
    }
}