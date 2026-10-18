class Solution {
    public int reverseDegree(String s) {
      int n=s.length();
      int sum=0;
      for(int i=0;i<n;i++){
      sum += (Math.abs(s.charAt(i)-'z')+1)*(i+1);
      } 
      return sum; 
    }
}