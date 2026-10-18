class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int n=nums.length;
        int op=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                op= op|nums[i];
            }
        }
        return op;
    }
}