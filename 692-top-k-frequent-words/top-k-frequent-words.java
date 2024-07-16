class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word: words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String word: freqMap.keySet()) {
            pq.offer(new Word(word, freqMap.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(pq.poll().word);
        }
        return result;
    }
}

class Word implements Comparable<Word> {
    String word;
    Integer frequency;

    public Word(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word that) {
        if (this.frequency.equals(that.frequency)) {
            return that.word.compareTo(this.word);
        }
        return this.frequency.compareTo(that.frequency);
    }
}