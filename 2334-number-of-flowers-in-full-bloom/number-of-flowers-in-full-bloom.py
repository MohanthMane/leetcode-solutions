import sortedcontainers

class Solution:
    def fullBloomFlowers(self, flowers, persons):
        diff = sortedcontainers.SortedDict({0: 0})
        for start, end in flowers:
            diff[start] = diff.get(start, 0) + 1
            diff[end + 1] = diff.get(end + 1, 0) - 1

        count = list(accumulate(diff.values()))
        return [count[diff.bisect(t) - 1] for t in persons]
