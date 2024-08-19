class Solution {

    private Map<String, Integer> dp = new HashMap<>();

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparing(job -> job.start));
        return solve(jobs, 0, 0);
    }

    private int solve(List<Job> jobs, int lastEndTime, int idx) {
        if (idx == jobs.size()) return 0;
        
        String key = idx + "_";
        if (dp.containsKey(key)) return dp.get(key);

        Job job = jobs.get(idx);
        int nextJobIdx = findNextJob(jobs, job.end);
        int take = job.profit + solve(jobs, job.end, nextJobIdx);
        int notTake = solve(jobs, lastEndTime, idx + 1);
        dp.put(key, Math.max(take, notTake));
        return dp.get(key);
    }

    private int findNextJob(List<Job> jobs, int currEndTime) {
        int l = 0, r = jobs.size() - 1, result = jobs.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (jobs.get(mid).start >= currEndTime) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}

class Job {
    Integer start, end, profit;

    public Job(Integer start, Integer end, Integer profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}