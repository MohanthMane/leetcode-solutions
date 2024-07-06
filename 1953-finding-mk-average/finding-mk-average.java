class MKAverage {
    
    int m;
    int k;
    TreeMap<Integer, Integer> lowBucket;
    TreeMap<Integer, Integer> midBucket;
    TreeMap<Integer, Integer> highBucket;
    int midBucketSum;
    int lowBucketSize;
    int highBucketSize;

    Deque<Integer> stream = new ArrayDeque<>();

    public MKAverage(int m, int k) {
        lowBucket = new TreeMap<>();
        midBucket = new TreeMap<>();
        highBucket = new TreeMap<>();

        midBucketSum = 0;
        lowBucketSize = 0;
        highBucketSize = 0;

        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        if (lowBucket.isEmpty() || num <= lowBucket.lastKey()) {
            lowBucket.merge(num, 1, Integer::sum);
            lowBucketSize++;
        } else if (highBucket.isEmpty() || num >= highBucket.firstKey()) {
            highBucket.merge(num, 1, Integer::sum);
            highBucketSize++;
        } else {
            midBucket.merge(num, 1, Integer::sum);
            midBucketSum += num;
        }

        stream.offer(num);

        if (stream.size() > m) {
            int oldestNum = stream.poll();

            if (lowBucket.containsKey(oldestNum)) {
                if (lowBucket.merge(oldestNum, -1, Integer::sum) == 0) {
                    lowBucket.remove(oldestNum);
                }
                lowBucketSize--;
            } else if (highBucket.containsKey(oldestNum)) {
                if (highBucket.merge(oldestNum, -1, Integer::sum) == 0) {
                    highBucket.remove(oldestNum);
                }
                highBucketSize--;
            } else {
                if (midBucket.merge(oldestNum, -1, Integer::sum) == 0) {
                    midBucket.remove(oldestNum);
                }
                midBucketSum -= oldestNum;
            }
        }

        balanceBucket();
    }
    
    public int calculateMKAverage() {
        if (stream.size() < m) {
            return -1;
        }

        return (int) (midBucketSum / (m - 2 * k));
    }

    private void balanceBucket() {
        while (lowBucketSize > k) {
            int element = lowBucket.lastKey();
            if (lowBucket.merge(element, -1, Integer::sum) == 0) {
                lowBucket.remove(element);
            }

            midBucket.merge(element, 1, Integer::sum);
            midBucketSum += element;

            lowBucketSize--;
        }

        while (highBucketSize > k) {
            int element = highBucket.firstKey();
            if (highBucket.merge(element, -1, Integer::sum) == 0) {
                highBucket.remove(element);
            }

            midBucket.merge(element, 1, Integer::sum);
            midBucketSum += element;

            highBucketSize--;
        }

        while (lowBucketSize < k && !midBucket.isEmpty()) {
            int element = midBucket.firstKey();
            if (midBucket.merge(element, -1, Integer::sum) == 0) {
                midBucket.remove(element);
            }
            midBucketSum -= element;

            lowBucket.merge(element, 1, Integer::sum);
            lowBucketSize++;
        }

        while (highBucketSize < k && !midBucket.isEmpty()) {
            int element = midBucket.lastKey();
            if (midBucket.merge(element, -1, Integer::sum) == 0) {
                midBucket.remove(element);
            }
            midBucketSum -= element;

            highBucket.merge(element, 1, Integer::sum);
            highBucketSize++;
        }
    }
}