class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> billCount = new HashMap<>();
        for (int bill: bills) {
            if (bill == 5) {
                billCount.put(bill, billCount.getOrDefault(bill, 0) + 1);
            } else if (bill == 10) {
                if (billCount.getOrDefault(5, 0) == 0) return false;
                billCount.put(bill, billCount.getOrDefault(bill, 0) + 1);
                billCount.put(5, billCount.getOrDefault(5, 0) - 1);
            } else {
                if (billCount.getOrDefault(5, 0) == 0) return false;
                if (billCount.getOrDefault(10, 0) == 0) {
                    if (billCount.get(5) < 3) {
                        return false;
                    } else {
                        billCount.put(5, billCount.getOrDefault(5, 0) - 3);
                    }
                } else {
                    billCount.put(10, billCount.getOrDefault(10, 0) - 1);
                    billCount.put(5, billCount.getOrDefault(5, 0) - 1);
                }
                billCount.put(bill, billCount.getOrDefault(bill, 0) + 1);
            }
        }
        return true;
    }
}