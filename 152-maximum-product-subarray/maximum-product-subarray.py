class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0

        max_so_far = nums[0]
        min_so_far = nums[0]
        result = nums[0]

        for i in range(1, len(nums)):
            curr = nums[i]
            temp_max = max(curr, max(max_so_far * curr, min_so_far * curr))
            min_so_far = min(curr, min(max_so_far * curr, min_so_far * curr))
            max_so_far = temp_max

            result = max(max_so_far, result)

        return result
        