class LFUCache {

    private final int capacity;
    private int minFreq = 0;
    private final Map<Integer, Integer> keyToVal = new HashMap<>();
    private final Map<Integer, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        final int freq = keyToFreq.get(key);
        freqToLRUKeys.get(freq).remove(key);
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq);
            ++minFreq;
        }

        putFreq(key, freq + 1);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // Update key's count
            return;
        }

        if (keyToVal.size() == capacity) {
            // Evict LRU key from the minFreq list
            final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
            freqToLRUKeys.get(minFreq).remove(keyToEvict);
            keyToVal.remove(keyToEvict);
        }

        minFreq = 1;
        putFreq(key, minFreq);
        keyToVal.put(key, value);
    }

    private void putFreq(int key, int freq) {
        keyToFreq.put(key, freq);
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToLRUKeys.get(freq).add(key);
    }
}
