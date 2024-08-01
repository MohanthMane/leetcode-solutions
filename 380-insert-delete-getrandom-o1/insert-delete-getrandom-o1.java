class RandomizedSet {

    private final List<Integer> nums;
    private final Map<Integer, Integer> indexMap;

    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        nums.add(val);
        int idx = nums.size() - 1;
        indexMap.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int lastIdx = nums.size() - 1;
        int idx = indexMap.get(val);

        nums.set(idx, nums.get(lastIdx));
        indexMap.put(nums.get(lastIdx), idx);

        nums.remove(lastIdx);
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = new Random().nextInt(0, nums.size());
        return nums.get(idx);
    }
}
