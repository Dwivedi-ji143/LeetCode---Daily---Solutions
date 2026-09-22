class Solution {
    public int minPartitions(String n) {
        char largest = n.charAt(0);
        for (int i=1;i<n.length();i++){
            if (n.charAt(i)>largest){
                largest= n.charAt(i);
            }
        }
        return largest-'0';
    }
}