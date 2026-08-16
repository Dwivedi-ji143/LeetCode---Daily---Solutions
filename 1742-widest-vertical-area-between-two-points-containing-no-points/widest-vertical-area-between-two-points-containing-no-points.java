class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int ans= 0;
        int op[] = new int[points.length];
        for (int i=0;i<n;i++){
            op[i]=points[i][0];
        }
        Arrays.sort(op);
        int j=0;
        while(j<n-1){
            if(op[j+1]-op[j]>ans){
                ans=op[j+1]-op[j];
            }
            j++;
        }
        return ans;
    }
}