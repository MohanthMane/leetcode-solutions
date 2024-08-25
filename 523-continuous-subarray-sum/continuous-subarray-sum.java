import java.util.HashMap;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0, sum = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;

            if (modSeen.containsKey(mod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(mod) > 1) {
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(mod, i);
            }
        }

        return false;
    }
}
