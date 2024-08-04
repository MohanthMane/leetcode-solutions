class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double result = Double.MAX_VALUE;
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            workers.add(new Worker(quality[i], (double) wage[i] / (double) quality[i]));
        }
        workers.sort(Comparator.comparing(worker -> worker.wagePerQuality));

        PriorityQueue<Integer> maxQualityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        Integer qualitySoFar = 0;
        for (Worker worker: workers) {
            maxQualityQueue.offer(worker.quality);
            qualitySoFar += worker.quality;
            if (maxQualityQueue.size() > k) {
                Integer removedQuality = maxQualityQueue.poll();
                qualitySoFar -= removedQuality;
            }
            if (maxQualityQueue.size() == k) {
                result = Math.min(result, worker.wagePerQuality * qualitySoFar);
            }
        }

        return result;
    }
}

class Worker {
    int quality;
    double wagePerQuality;

    public Worker(int quality, double wagePerQuality) {
        this.quality = quality;
        this.wagePerQuality = wagePerQuality;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "quality=" + quality +
                ", wagePerQuality=" + wagePerQuality +
                '}';
    }
}