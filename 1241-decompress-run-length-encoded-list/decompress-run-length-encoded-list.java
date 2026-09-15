class Solution {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;

        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }

        int[] result = new int[size];

        int idx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, idx, idx + nums[i], nums[i + 1]);
            idx += nums[i];
        }

        return result;
    }
}