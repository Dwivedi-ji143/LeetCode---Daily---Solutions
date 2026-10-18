class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int k= requests.length;
        int op=requests[0];
        for (int i=1;i<k;i++){
            op+=Math.abs(requests[i]-requests[i-1]);
        }
        return op;
    }
}