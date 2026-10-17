class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int s = Math.max(0, i - nums[i]);

            for (int j = s; j <= i; j++) {
                total += nums[j];
            }
        }
        return total;
    }
}
