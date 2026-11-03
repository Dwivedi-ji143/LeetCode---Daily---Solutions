class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int op=0;
        for(int i=0;i<n;i++){
            op+=Math.abs(nums[i]-nums[n-1]);
        }
        return op;
    }
}