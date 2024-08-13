class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }
        jobs.sort(Comparator.comparing(job -> job.difficulty));
        Arrays.sort(workers);

        int totalProfit = 0, currentProfit = 0, idx = 0;
        for (int i = 0; i < workers.length; i++) {
            while (idx < difficulty.length && workers[i] >= jobs.get(idx).difficulty) {
                currentProfit = Math.max(currentProfit, jobs.get(idx).profit);
                idx++;
            }
            totalProfit += currentProfit;
        }
        return totalProfit;
    }
}

class Job {
    int difficulty, profit;

    public Job(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}