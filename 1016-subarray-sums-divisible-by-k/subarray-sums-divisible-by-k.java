class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int currentMod = 0;
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        for (int num : nums) {
            currentMod = (((currentMod + num) % k) + k) % k;
            modGroups[currentMod]++;
        }
        int result = 0;
        for (int modGroup : modGroups) {
            result += modGroup * (modGroup - 1) / 2;
        }
        return result;
    }
}