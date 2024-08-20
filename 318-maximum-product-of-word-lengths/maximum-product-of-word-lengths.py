class Solution:
    def maxProduct(self, words):
        # Dictionary to store bitmask -> max length of all strings with same bitmask
        mask_map = {}
        
        for word in words:
            mask = 0
            for c in word:
                mask |= 1 << (ord(c) - ord('a'))
            mask_map[mask] = max(mask_map.get(mask, 0), len(word))
        
        result = 0
        for x in mask_map:
            for y in mask_map:
                if x & y == 0:
                    result = max(result, mask_map[x] * mask_map[y])
        
        return result
