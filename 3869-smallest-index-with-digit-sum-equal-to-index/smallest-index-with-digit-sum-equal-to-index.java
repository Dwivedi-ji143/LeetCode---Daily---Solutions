class Solution {
    public int smallestIndex(int[] nums) {
        int n= nums.length;
        for (int i=0;i<n;i++){
            int sum=0;
            if(nums[i]<10 && i==nums[i]){
                return i;
            }
            else if(nums[i]>=10){
                int k=nums[i];
                while(k>0){
                    sum+=k%10;
                    k/=10;
                }
                if(sum == i){
                    return i;
                }
            }
        }
        return -1;
    }
}